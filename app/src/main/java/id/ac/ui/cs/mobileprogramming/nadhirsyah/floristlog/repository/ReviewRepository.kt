package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository

import android.app.Application
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao.FlowerDAO
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao.ReviewDAO
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.database.FlowerDatabase
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ReviewRepository (application: Application) {

    private var reviewDao : ReviewDAO? = null
    private var reviews : LiveData<List<Review>>? = null
    private var reviewByFlowerId : LiveData<List<Review>>? = null

    init{
        val db = FlowerDatabase.getInstance(application.applicationContext)
        reviewDao = db?.reviewDao()
        reviews = reviewDao?.getAllReview()
    }

    fun getAllReview(): LiveData<List<Review>>? {
        return reviews
    }

    fun insertReview(review: Review) = runBlocking {
        this.launch(Dispatchers.IO) {
            reviewDao?.insertReview(review)
        }
    }

    fun delete(review: Review){
        runBlocking {
            this.launch(Dispatchers.IO) {
                reviewDao?.deleteReview(review)
            }
        }
    }

    fun update(review: Review){
        runBlocking {
            this.launch(Dispatchers.IO) {
                reviewDao?.updateReview(review)
            }
        }
    }
    fun getReviewByFlowerId(id : Int): LiveData<List<Review>>?{
        runBlocking {
            this.launch(Dispatchers.IO) {
                reviewByFlowerId = reviewDao?.getReviewByFlowerId(id)
            }
        }
        return reviewByFlowerId
    }

}