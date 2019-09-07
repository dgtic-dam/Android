package com.cybertch.activitylife

import android.content.Intent
<<<<<<< HEAD
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
=======
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
>>>>>>> 902c485efad0ffb0800e0bf4c3314545ac68001e
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() { //herencia definida con :, con los paréntesis se está instanciando la clase

    override fun onCreate(savedInstanceState: Bundle?) { //Optional ?
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // R, clase de referencia a los objetos en xml
        setSupportActionBar(toolbar)
        Log.d("[STATE]" , "create" )
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show() //operaciones lamda
        }
        fab.setOnClickListener { view ->
            var intent=Intent(Intent.ACTION_CALL, Uri.parse("tel:5556666666"))
            startActivity(intent)
        }*/

<<<<<<< HEAD
       /* fab.setOnClickListener { view ->
            var intent=Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:dannas@protonmail.com"))
            startActivity(intent)
        }*/
        fab.setOnClickListener { view ->
            var intent=Intent(this,EmptyActivity::class.java)
=======
        Log.d("[STATE]", "created")

        fab.setOnClickListener { view ->
            val intent = Intent(this, EmptyActivity::class.java)
>>>>>>> 902c485efad0ffb0800e0bf4c3314545ac68001e
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("[STATE]" , "paused" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("[STATE]" , "restarted" )
    }

    override fun onResume() {
        super.onResume()
        Log.d("[STATE]" , "resumed" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("[STATE]" , "stoped" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("[STATE]" , "destroyed" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("[STATE]", "paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("[STATE]", "restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.d("[STATE]", "resumed")
    }

    override fun onStop() {
        Log.d("[STATE]", "stoped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("[STATE]", "destroyed")
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
