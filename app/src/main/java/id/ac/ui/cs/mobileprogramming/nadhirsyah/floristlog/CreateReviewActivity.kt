package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class CreateReviewActivity:AppCompatActivity() {
    private val galleryRequest:Int = 9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_review)

        val buttonCreate: Button = findViewById(R.id.buttonCreate)
        buttonCreate.setOnClickListener{
            getImageFromGallery()
        }

    }
    private fun getImageFromGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, galleryRequest)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==galleryRequest&&data!=null){
            val imageUri: Uri? = data.data
            val imageViewReview:ImageView =findViewById(R.id.imageViewReview)
            Log.d("IMAGE", imageUri.toString())
            imageViewReview.setImageURI(imageUri)
            imageViewReview.visibility = View.VISIBLE

        }
    }
}