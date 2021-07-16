package com.example.orientationchange

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    var count = 0

//Overriding the onCreate method in the AppCompatActivity class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count ++

//      Set reference for the button that navigates to second activity
        val btnSecondImplementation = findViewById<Button>(R.id.btnSecondImplementation)

//      Set click event listener to navigate to the fragment activity
        btnSecondImplementation.setOnClickListener {

//          Create an intent object and navigate to the fragment activity
            val intent = Intent(this,FragmentActivity::class.java)
            startActivity(intent)

        }

//      on state change, change the text to activity started
        findViewById<TextView>(R.id.stateText).text = String.format("Activity Created")

    }

//Overriding the onStart method in the AppCompatActivity class
    override fun onStart() {
        super.onStart()

//      Delay the activity lifecycle at this phase by 2000 milliseconds
        Timer().schedule(timerTask {
            findViewById<TextView>(R.id.stateText).text = String.format("Activity Started")
        }, 2000)
    }

//Overriding the onPause method in the AppCompatActivity class
    override fun onPause() {
        super.onPause()

        findViewById<TextView>(R.id.stateText).text = String.format("Activity Paused")

    }

    override fun onRestart() {
        super.onRestart()
        Timer().schedule(timerTask {
            findViewById<TextView>(R.id.stateText).text = String.format("Activity Restarted")
        }, 3000)    }

    override fun onStop() {
        super.onStop()
        Timer().schedule(timerTask {
            findViewById<TextView>(R.id.stateText).text = String.format("Activity Stopped")
        }, 6000)
        }

//Overriding the onResume method in the AppCompatActivity class
    override fun onResume() {
        super.onResume()
        Timer().schedule(timerTask {
            findViewById<TextView>(R.id.stateText).text = String.format("Activity Resumed")
        }, 5000)
    }

//Overriding the onSaveInstanceState method in the AppCompatActivity class
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
//      Save the value of count
        outState.putInt("count", count)
    }

//Overriding the onConfigurationChanged method in the AppCompatActivity class
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val orientationText = findViewById<TextView>(R.id.orientationText)

//      Check for orientation change and increase the value of count.
//      attach the value of count to the text displaying the orientation.
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            count ++
            orientationText.text = String.format("landscape Orientation: $count")
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            count ++
            orientationText.text = String.format("Portrait orientation: $count")
        }
    }

}