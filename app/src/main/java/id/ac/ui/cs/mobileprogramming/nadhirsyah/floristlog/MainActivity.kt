package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val product = findViewById<LinearLayout>(R.id.product_ll)
        product.setOnClickListener{
            navToProductActivity()
        }
    }
    private fun navToProductActivity() {
        val intent = Intent(this, FlowerActivity::class.java).apply {
        }
        startActivity(intent)
    }
}