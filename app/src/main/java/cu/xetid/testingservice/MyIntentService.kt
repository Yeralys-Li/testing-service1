package cu.xetid.testingservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    init {
        intence = this
    }

    companion object {
        private lateinit var intence: MyIntentService
        var isRunning = false

        fun stopservice() {
            Log.d("TAF", "OFF")
            isRunning = false
            intence.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("TAF", "ON")
                Thread.sleep(1000)

            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}