package com.cybertch.activitylife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
<<<<<<< HEAD
        Log.d("[STATE2]" , "created" )
=======
        Log.d("[STATE2]","created")
>>>>>>> 902c485efad0ffb0800e0bf4c3314545ac68001e
    }

    override fun onPause() {
        super.onPause()
<<<<<<< HEAD
        Log.d("[STATE2]" , "paused" )
=======
        Log.d("[STATE2]","paused")
>>>>>>> 902c485efad0ffb0800e0bf4c3314545ac68001e
    }

    override fun onRestart() {
        super.onRestart()
<<<<<<< HEAD
        Log.d("[STATE2]" , "restarted" )
=======
        Log.d("[STATE2]","restarted")
>>>>>>> 902c485efad0ffb0800e0bf4c3314545ac68001e
    }

    override fun onResume() {
        super.onResume()
<<<<<<< HEAD
        Log.d("[STATE2]" , "resumed" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("[STATE2]" , "stoped" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("[STATE2]" , "destroyed" )
=======
        Log.d("[STATE2]","resumed")
    }

    override fun onStop() {
        Log.d("[STATE2]","stoped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("[STATE2]","destroyed")
        super.onDestroy()
>>>>>>> 902c485efad0ffb0800e0bf4c3314545ac68001e
    }
}
