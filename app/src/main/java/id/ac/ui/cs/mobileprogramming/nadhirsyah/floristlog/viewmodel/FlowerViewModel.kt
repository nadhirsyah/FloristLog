package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.FlowerRepository

class FlowerViewModel(application: Application) : AndroidViewModel(application) {

    private var flowerRepository = FlowerRepository(application)
    private var flowers : LiveData<List<Flower>>? = flowerRepository.getAllFlowers()

    fun insertFlower(flower: Flower) {
        Log.d("insert", flower.id.toString())
        flowerRepository.insertFlower(flower)
    }

    fun getAllFlower(): LiveData<List<Flower>>? {
        return flowers
    }

    fun deleteFlower(flower: Flower) {
        flowerRepository.delete(flower)
    }

    fun updateFlower(flower: Flower) {
        flowerRepository.update(flower)
    }
}