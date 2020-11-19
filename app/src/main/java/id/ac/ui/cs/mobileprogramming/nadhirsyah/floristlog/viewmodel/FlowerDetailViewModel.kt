package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.FlowerRepository

class FlowerDetailViewModel(application: Application) : AndroidViewModel(application)  {
    private var flowerRepository = FlowerRepository(application)
    private lateinit var flower : Flower

    fun getFlower(id: Int): Flower?{
        flower = flowerRepository.getFlower(id)!!
        return flower
    }
}