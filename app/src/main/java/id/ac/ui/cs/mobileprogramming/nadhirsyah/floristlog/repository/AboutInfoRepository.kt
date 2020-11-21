package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository

import android.app.Application
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.api.RetrofitInstance
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao.AboutInfoDAO
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.database.FlowerDatabase
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.About
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.AboutInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class AboutInfoRepository(application: Application) {

    private var aboutInfoDao : AboutInfoDAO? = null
    private var aboutInfo : AboutInfo? = null
    init{
        val db = FlowerDatabase.getInstance(application.applicationContext)
        aboutInfoDao = db?.aboutInfoDao()
    }
    fun getAboutInfo(id : Int): AboutInfo?{
        runBlocking {
            this.launch(Dispatchers.IO) {
                aboutInfo = aboutInfoDao?.getAboutInfo(1)
            }
        }
        return aboutInfo
    }
    fun insertAbout(aboutInfo: AboutInfo) = runBlocking {
        this.launch(Dispatchers.IO) {
            aboutInfoDao?.insert(aboutInfo)
        }
    }

}