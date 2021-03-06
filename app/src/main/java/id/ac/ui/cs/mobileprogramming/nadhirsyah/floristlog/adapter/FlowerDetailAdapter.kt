package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.FlowerDetailActivity
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.R
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Flower
import kotlinx.android.synthetic.main.activity_item_product.view.*

class FlowerDetailAdapter(private val context: Context?) :
    RecyclerView.Adapter<FlowerDetailAdapter.FlowerViewHolder>() {

    private var flowers = listOf<Flower>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        return FlowerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_item_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = flowers.size

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        if (context != null){
            holder.bindItem(context, flowers[position])
        }
    }

    fun setFlowers(flowers: List<Flower>){
        this.flowers = flowers
        notifyDataSetChanged()
    }
    class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(context: Context, flower: Flower) {
            itemView.flowerTextList.text = flower.name
        }
    }
    }