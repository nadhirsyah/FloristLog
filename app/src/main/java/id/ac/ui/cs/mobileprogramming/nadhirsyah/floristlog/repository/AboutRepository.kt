package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository

import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.api.RetrofitInstance
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.About
import retrofit2.Response

class AboutRepository() {

    suspend fun getAbout() : Response<About> {
        return RetrofitInstance.api.getAbout()
    }

}