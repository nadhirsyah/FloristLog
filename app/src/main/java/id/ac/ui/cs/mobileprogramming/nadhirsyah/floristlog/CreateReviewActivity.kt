package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.model.Review
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel.ReviewViewModel


class CreateReviewActivity:AppCompatActivity() {
    private val galleryRequest:Int = 9
    private lateinit var reviewViewModel: ReviewViewModel
    private lateinit var imageUri: Uri
    private var flowerId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_review)
        val intentExtras = intent.extras
        if (intentExtras != null){
            flowerId = intentExtras.getString("flowerId")?.toInt()?: 0
        }
        reviewViewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)

        val buttonCreate: Button = findViewById(R.id.buttonCreate)
        buttonCreate.setOnClickListener{
            getImageFromGallery()
        }
        val buttonAddReview : Button = findViewById(R.id.buttonAddReview)
        buttonAddReview.setOnClickListener {
            addReview()
        }

    }

    private fun addReview() {
        val textViewReview: EditText = findViewById(R.id.editTextReview)
        Log.d("nama", textViewReview.text.toString())
        reviewViewModel.insertReview(
            Review(
                text = textViewReview.text.toString(),
                flowerID = flowerId.toString(),
                imageUri = imageUri.toString()
            )
        )
        val intent = Intent(this, FlowerDetailActivity::class.java)
        intent.putExtra("id",flowerId.toString())
        startActivity(intent)
    }

    private fun getImageFromGallery() {
        if (ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) ==  PackageManager.PERMISSION_GRANTED) {
            val intent = Intent()
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            intent.type = "image/*"
            intent.flags = (Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
            startActivityForResult(intent, galleryRequest)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                READ_EXTERNAL_STORAGE_REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==galleryRequest&&data!=null){
            imageUri = data.data!!
            val img = findViewById<ImageView>(R.id.imageViewReview)
            img.setImageURI(imageUri)
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            READ_EXTERNAL_STORAGE_REQUEST_CODE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // pick image after request permission success
                    getImageFromGallery()
                }
            }
        }
    }
    companion object {
        const val PICK_IMAGE_REQUEST_CODE = 1000
        const val READ_EXTERNAL_STORAGE_REQUEST_CODE = 1001
    }
}