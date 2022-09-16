package cu.xetid.testingservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangesReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnable = intent?.getBooleanExtra("state", false)?:return
        if (isEnable) {
          Toast.makeText(context,"ON",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context,"OFF",Toast.LENGTH_LONG).show()
        }
    }
}