package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter.FlowerDetailAdapter
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter.ReviewAdapter
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.FlowerViewModel
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.ReviewViewModel
import kotlinx.android.synthetic.main.activity_flower_detail.*

class FlowerDetailActivity:AppCompatActivity() {
    private lateinit var flowerViewModel: FlowerViewModel
    private lateinit var flowerDetailAdapter: FlowerDetailAdapter

    private lateinit var reviewViewModel: ReviewViewModel
    private lateinit var reviewAdapter: ReviewAdapter

    private lateinit var flower : Flower
    private var flowerId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_detail)

        val intentExtras = intent.extras
        if (intentExtras != null){
            flowerId = intentExtras.getString("id")?.toInt()?: 0
        }

        flowerViewModel = ViewModelProvider(this).get(FlowerViewModel::class.java)
        flower = flowerViewModel.getFlower(flowerId)!!
        findViewById<TextView>(R.id.flowerDetailName).text = flower.name
        findViewById<TextView>(R.id.flowerDetailPrice).text = flower.price
        Picasso.get()
            .load(flower.img_link)
            .into(findViewById<ImageView>(R.id.flowerDetailImage))

        reviewRecyclerView.layoutManager = LinearLayoutManager(this)
        reviewAdapter = ReviewAdapter(this)
        reviewRecyclerView.adapter = reviewAdapter

        val addReviewButton: Button = findViewById(R.id.buttonAdd)
        addReviewButton.setOnClickListener{
            val intent = Intent(this, CreateReviewActivity::class.java)
            intent.putExtra("flowerId",flower.id.toString())
            startActivity(intent)
        }
        reviewViewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)
        reviewViewModel.getAllReview()?.observe(this, Observer {
            reviewAdapter.setFlowers(it)
        })
    }

}