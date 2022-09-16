package cu.xetid.testingservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class LocationService : Service() {

    companion object {
        //        var mLocation: Location? = null
        var isServiceStarted = false
        var builder: NotificationCompat.Builder? = null
    }

    val TAG = "LocationService"


    init {
        Log.d(TAG, "SERVICE RUN.. ")
    }

    private val NOTIFICATION_CHANNEL_ID = "my_notification_location"
    private val NOTIFICATION_ID = 12345678;

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate")
        isServiceStarted = true
        builder =
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setOngoing(true)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText(getString(R.string.app_name))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Notificacion", NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationChannel.description = NOTIFICATION_CHANNEL_ID
            notificationChannel.setSound(null, null)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        startForeground(NOTIFICATION_ID, builder?.build())
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        isServiceStarted = false
        builder?.let {
        stopForeground(true)
        }
        Log.d(TAG, "SERVICE STOP.. ")
    }
}