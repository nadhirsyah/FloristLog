package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower

@Dao
interface FlowerDAO {

    @Insert
    fun insertFlower(flower: Flower)

    @Delete
    suspend fun deleteFlower(flower: Flower)

    @Update
    suspend fun updateFlower(flower: Flower)

    @Query("DELETE FROM flower_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM flower_table ")
    fun getAllFlowers(): LiveData<List<Flower>>

    @Query("SELECT * FROM flower_table WHERE id = :id")
    fun getFlower(id: Int): Flower

    @Insert
    @JvmSuppressWildcards
    fun insertAll(objects: List<Flower>)
}