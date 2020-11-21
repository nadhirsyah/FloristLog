package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.AboutInfo
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.AboutRepository
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.AboutInfoViewModel
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.AboutViewModel
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.AboutViewModelFactory

class AboutActivity:AppCompatActivity() {
    private lateinit var viewModel:AboutViewModel

    private lateinit var aboutInfoViewModel : AboutInfoViewModel
    private lateinit var aboutInfo : AboutInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        aboutInfoViewModel = ViewModelProvider(this).get(AboutInfoViewModel::class.java)
        if (aboutInfoViewModel.getAboutInfo(1) != null){
            aboutInfo = aboutInfoViewModel.getAboutInfo(1)!!
            val textViewAbout = findViewById<TextView>(R.id.textViewAbout)
            textViewAbout.text = aboutInfo.body
        } else {
            val repository = AboutRepository()
            val viewModelFactory = AboutViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(AboutViewModel::class.java)
            viewModel.getAbout()
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    Log.d("Response", response.body()?.body!!)
                    val textViewAbout = findViewById<TextView>(R.id.textViewAbout)
                    textViewAbout.text = response.body()?.body!!
                    aboutInfoViewModel.insertAbout(
                        AboutInfo(
                            id = 1,
                            body = response.body()?.body!!
                        )
                    )
                } else {
                    val textViewAbout = findViewById<TextView>(R.id.textViewAbout)
                    textViewAbout.text = response.code()?.toString()
                }
            })

        }
    }
}