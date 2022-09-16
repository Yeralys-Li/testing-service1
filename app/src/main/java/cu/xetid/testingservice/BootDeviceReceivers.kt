package cu.xetid.testingservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat

class BootDeviceReceivers : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        /**
         * Para levantar el servicio de nuevo si enciende el dispositivo desde cero
         */
        context?.let {
            ContextCompat.startForegroundService(it, Intent(it, LocationService::class.java))
            val appName = context.getString(R.string.app_name)
            Toast.makeText(context, "$appName inicializada", Toast.LENGTH_LONG).show()
        }
    }
}
