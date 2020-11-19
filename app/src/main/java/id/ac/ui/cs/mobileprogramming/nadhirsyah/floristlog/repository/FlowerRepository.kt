package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository


import android.app.Application
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao.FlowerDAO
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.database.FlowerDatabase
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FlowerRepository(application: Application) {

    private var flowerDao : FlowerDAO? = null
    private var flowers : LiveData<List<Flower>>? = null
    private var flower : Flower? = null

    init{
        val db = FlowerDatabase.getInstance(application.applicationContext)
        flowerDao = db?.flowerDao()
        flowers = flowerDao?.getAllFlowers()
    }

    fun getAllFlowers(): LiveData<List<Flower>>? {
        return flowers
    }

    fun insertFlower(flower: Flower) = runBlocking {
        this.launch(Dispatchers.IO) {
            flowerDao?.insertFlower(flower)
        }
    }

    fun insertAll(flowers: List<Flower>) = runBlocking {
        this.launch(Dispatchers.IO) {
            flowerDao?.insertAll(flowers)
        }
    }

    fun delete(flower: Flower){
        runBlocking {
            this.launch(Dispatchers.IO) {
                flowerDao?.deleteFlower(flower)
            }
        }
    }

    fun update(flower: Flower){
        runBlocking {
            this.launch(Dispatchers.IO) {
                flowerDao?.updateFlower(flower)
            }
        }
    }
    fun getFlower(id : Int): Flower?{
        runBlocking {
            this.launch(Dispatchers.IO) {
                flower = flowerDao?.getFlower(id)
            }
        }
        return flower
    }

}