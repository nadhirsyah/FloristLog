package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao.FlowerDAO
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao.ReviewDAO
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import java.util.concurrent.Executors

@Database(entities = [Flower::class, Review::class], version = 3, exportSchema = false)
abstract class FlowerDatabase : RoomDatabase() {

    abstract fun flowerDao() : FlowerDAO
    abstract fun reviewDao() : ReviewDAO

    companion object{
        @Volatile
        private var instance : FlowerDatabase? = null

        fun getInstance(context: Context):FlowerDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it}

            }
        }
        private fun buildDatabase(context: Context): FlowerDatabase {
            return Room.databaseBuilder(context, FlowerDatabase::class.java, "flower_data_database")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            instance?.let {
                                it.flowerDao().insertAll(DataGenerator.getFlower())
                            }
                        }
                    }
                })
                .build()
        }
    }
}