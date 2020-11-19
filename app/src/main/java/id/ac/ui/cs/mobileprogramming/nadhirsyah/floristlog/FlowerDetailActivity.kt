package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter.FlowerAdapter
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter.FlowerDetailAdapter
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter.ReviewAdapter
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.FlowerDetailViewModel
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.ReviewViewModel
import kotlinx.android.synthetic.main.activity_flower_detail.*

class FlowerDetailActivity:AppCompatActivity() {
    private lateinit var flowerDetailViewModel : FlowerDetailViewModel
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

        flowerDetailViewModel = ViewModelProvider(this).get(FlowerDetailViewModel::class.java)
        flower = flowerDetailViewModel.getFlower(flowerId)!!
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
            startActivity(intent)
        }
        reviewViewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)
        reviewViewModel.getAllReview()?.observe(this, Observer {
            reviewAdapter.setFlowers(it)
        })
    }

    private fun showAlertDialogAdd(flower: Flower){
        val alert = AlertDialog.Builder(this)

        val editText = EditText(applicationContext)
        editText.hint = "Enter your text"

        alert.setTitle("New Note")
        alert.setView(editText)

        alert.setPositiveButton("Save") { dialog, _ ->
            reviewViewModel.insertReview(
                Review(
                    text = editText.text.toString(),
                    flowerID = flower.id.toString(),
                )
            )
            dialog.dismiss()
        }

        alert.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        alert.show()
    }

}