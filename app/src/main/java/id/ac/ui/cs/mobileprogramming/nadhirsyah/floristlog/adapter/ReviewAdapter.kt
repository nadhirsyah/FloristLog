package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.R
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import kotlinx.android.synthetic.main.activity_item_product.view.*

class ReviewAdapter(private val context: Context?) :
    RecyclerView.Adapter<ReviewViewHolder>() {

    private var reviews = listOf<Review>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_item_product,
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
        itemView.setOnClickListener {
            Log.d("Review Id", review.id.toString())
        }
    }
}