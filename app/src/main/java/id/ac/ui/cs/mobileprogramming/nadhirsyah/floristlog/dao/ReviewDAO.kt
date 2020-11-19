package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review

@Dao
interface ReviewDAO {

    @Query("SELECT * FROM review_table")
    fun getAllReview(): LiveData<List<Review>>

    @Query("SELECT * FROM review_table WHERE flowerId=:flowerId")
    fun getReviewByFlowerId(flowerId: Int): LiveData<List<Review>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertReview(review: Review)

    @Delete
    suspend fun deleteReview(review: Review)

    @Update
    suspend fun updateReview(review: Review)
}