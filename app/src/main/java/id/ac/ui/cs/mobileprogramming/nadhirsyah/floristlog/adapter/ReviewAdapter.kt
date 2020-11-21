package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.R
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import kotlinx.android.synthetic.main.activity_item_product.view.*
import kotlinx.android.synthetic.main.activity_item_review.view.*

class ReviewAdapter(private val context: Context?) :
    RecyclerView.Adapter<ReviewViewHolder>() {

    private var reviews = listOf<Review>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_item_review,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = reviews.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        if (context != null){
            holder.bindItem(context, reviews[position])
        }
    }

    fun setFlowers(reviews: List<Review>){
        this.reviews = reviews
        notifyDataSetChanged()
    }

}
class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bindItem(context: Context, review: Review) {
        Log.d("RecipeAdapter", review.id.toString())
        itemView.reviewTextList.text = review.text
//        itemView.reviewImageList.setImageURI(Uri.parse(review.imageUri))
        Picasso.get().load(review.imageUri).into(itemView.reviewImageList);

        itemView.setOnClickListener {
            Log.d("Review Id", review.id.toString())
            Log.d("Review name", review.text)
            Log.d("Review imageUri", review.imageUri)
        }
    }
}