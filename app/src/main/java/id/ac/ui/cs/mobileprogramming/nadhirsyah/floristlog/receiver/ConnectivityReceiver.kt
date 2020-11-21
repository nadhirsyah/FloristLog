package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ConnectivityReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
            val noConnectivity = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            )
            if (noConnectivity) {
                Toast.makeText(context, "Internet Unavailable", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Internet Available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}