package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter.FlowerAdapter
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.FlowerViewModel
import kotlinx.android.synthetic.main.activity_list_product.*

class FlowerActivity : AppCompatActivity() {
    private lateinit var flowerViewModel : FlowerViewModel
    private lateinit var flowerAdapter: FlowerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)

        flowerRecyclerView.layoutManager = LinearLayoutManager(this)
        flowerAdapter = FlowerAdapter(this)
        flowerRecyclerView.adapter = flowerAdapter

        flowerViewModel = ViewModelProvider(this).get(FlowerViewModel::class.java)
        flowerViewModel.getAllFlower()?.observe(this, Observer {
            flowerAdapter.setFlowers(it)
        })

    }

}