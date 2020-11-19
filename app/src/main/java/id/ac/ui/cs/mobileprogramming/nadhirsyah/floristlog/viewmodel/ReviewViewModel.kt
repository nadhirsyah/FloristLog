package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.ReviewRepository

class ReviewViewModel(application: Application) : AndroidViewModel(application) {
    private var reviewRepository = ReviewRepository(application)
    private var reviews : LiveData<List<Review>>? = reviewRepository.getAllReview()

    fun insertReview(review: Review) {
        Log.d("insert", review.id.toString())
        reviewRepository.insertReview(review)
    }

    fun getAllReview(): LiveData<List<Review>>? {
        return reviews
    }

    fun deleteReview(review: Review) {
        reviewRepository.delete(review)
    }

    fun updateReview(review: Review) {
        reviewRepository.update(review)
    }
}