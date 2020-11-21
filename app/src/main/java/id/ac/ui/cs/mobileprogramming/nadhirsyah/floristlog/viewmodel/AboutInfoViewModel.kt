package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.About
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.AboutInfo
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.AboutInfoRepository
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.AboutRepository
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.FlowerRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AboutInfoViewModel(application: Application) : AndroidViewModel(application) {
    private var aboutInfoRepository = AboutInfoRepository(application)
    private lateinit var aboutInfo: AboutInfo

    fun getAboutInfo(id: Int): AboutInfo?{
        if (aboutInfoRepository.getAboutInfo(1) != null) {
            aboutInfo = aboutInfoRepository.getAboutInfo(1)!!
            return aboutInfo
        }
        return null
    }
    fun insertAbout(aboutInfo: AboutInfo) {
        aboutInfoRepository.insertAbout(aboutInfo)
    }
}