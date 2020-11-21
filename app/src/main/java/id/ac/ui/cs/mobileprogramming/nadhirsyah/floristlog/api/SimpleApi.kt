package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.api

import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.About
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("raw/U4y9Tk22")
    suspend fun getAbout() : Response<About>
}