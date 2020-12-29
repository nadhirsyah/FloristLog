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
        val about = findViewById<LinearLayout>(R.id.settings_ll)
        about.setOnClickListener {
            navToAboutActivity()
        }
        val timer = findViewById<LinearLayout>(R.id.timer_ll)
        about.setOnClickListener {
            navToTimerActivity()
        }
    }

    private fun navToAboutActivity() {
        val intent = Intent(this, AboutActivity::class.java).apply {
        }
        startActivity(intent)
    }

    private fun navToProductActivity() {
        val intent = Intent(this, FlowerActivity::class.java).apply {
        }
        startActivity(intent)
    }
    private fun navToTimerActivity() {
        val intent = Intent(this, TimerActivity::class.java).apply {
        }
        startActivity(intent)
    }
}