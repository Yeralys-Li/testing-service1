package cu.xetid.testingservice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import cu.xetid.testingservice.LocationService.Companion.isServiceStarted
import cu.xetid.testingservice.ui.theme.TestingServiceTheme

class MainActivity : ComponentActivity() {

//    lateinit var receiver: AirplaneModeChangesReceiver

    var name = "Service"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TestingServiceTheme {
                Scaffold() {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Button(onClick = {
                                ContextCompat.startForegroundService(
                                    this@MainActivity,
                                    Intent(this@MainActivity, LocationService::class.java)
                                )
                            }) {
                                Text(text = "Start")
                            }
                            Spacer(modifier = Modifier.width(50.dp))
                            Button(onClick = {
                                Intent(this@MainActivity, LocationService::class.java).also {
                                    stopService(it)
                                }

                            }) {
                                Text(text = "Stop")
                            }
                        }

                        Text("Service $isServiceStarted")
                    }
                }
            }


//            Intent(this@MainActivity, MyIntentService::class.java).also {
//                stopService(it)
//            }

//            val text = remember { mutableStateOf("") }
//
//            Scaffold() {
//                Column(
//                    verticalArrangement = Arrangement.Top,
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    Row(
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                    ) {
//                        Button(onClick = {
//                            Intent(this@MainActivity,MyService::class.java).also{
//                                startService(it)
//                                text.value = "Running"
//                            }
////                            Intent(this@MainActivity, MyIntentService::class.java).also {
////                                startService(it)
////                                text.value = "Running"
////                            }
//                        }) {
//                            Text(text = "Start")
//                        }
////                    Spacer(modifier = Modifier.width(50.dp))
//                        Button(onClick = {
//                            Intent(this@MainActivity,MyService::class.java).also{
//                                stopService(it)
//                                text.value = "Stop"
//                            }
////                            MyIntentService.stopservice()
//                            text.value = "Stop"
//                        }) {
//                            Text(text = text.value)
//                        }
//                        Button(onClick = {
//                            Intent(this@MainActivity,MyService::class.java).also{
//                               val dataString =   text.value
//                                it.putExtra("EXTRA_DATA",dataString)
//                                startService(it)
//                            }
////                            Intent(this@MainActivity, MyIntentService::class.java).also {
////                                startService(it)
////                                text.value = "Running"
////                            }
//                        }) {
//                            Text(text = "Send DATA")
//                        }
//                    }
//
//                    Text(text.value)
//                }
//            }
//            TestingServiceTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//
//                    receiver = AirplaneModeChangesReceiver()
//
//                    IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
//                        registerReceiver(receiver, it)
//                    }
//                }
//            }


        }
    }

    override fun onStop() {
        super.onStop()
//        unregisterReceiver(receiver)
    }
}

@Composable
fun init(activity: ComponentActivity) {

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestingServiceTheme {
        Scaffold() {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Button(onClick = {}) {
                        Text(text = "Start")
                    }
//                    Spacer(modifier = Modifier.width(50.dp))
                    Button(onClick = {}) {
                        Text(text = "Stop")
                    }
                }

                Text("Service stopped")
            }
        }
    }
}