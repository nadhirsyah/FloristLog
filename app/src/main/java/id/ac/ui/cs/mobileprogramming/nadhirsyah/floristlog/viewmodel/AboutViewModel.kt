package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.About
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.AboutRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AboutViewModel(private val repository: AboutRepository): ViewModel() {
    val myResponse:MutableLiveData<Response<About>> = MutableLiveData()

    fun getAbout(){
        viewModelScope.launch {
            val response : Response<About> = repository.getAbout()
            myResponse.value = response
        }
    }
}