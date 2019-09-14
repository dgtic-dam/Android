package com.cybertch.fragmentsexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.cybertch.fragmentsexample.fragment.DetailFragment
import com.cybertch.fragmentsexample.fragment.MainFragment
import com.cybertch.fragmentsexample.model.Contact

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if(savedInstanceState==null){//Bundle
            supportFragmentManager
                .beginTransaction()
                .add(R.id.containerMain, MainFragment.newInstance())
                .commit()
            if (resources.getBoolean(R.bool.is_tablet)){
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.containerDetail, DetailFragment.newInstance(Contact(0,"","",""))).commit()
            }
        }

      /*  Log.d("[STATE]","CREATED")*/

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    /*override fun onStart() {
        super.onStart()
        Log.d("[STATE]","STARTED")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("[STATE]","RESTARTED")
    }

    override fun onResume() {
        super.onResume()
        Log.d("[STATE]","RESUMED")
    }

    override fun onPause() {
        super.onPause()
        Log.d("[STATE]","PAUSED")
    }

    override fun onStop() {
        super.onStop()
        Log.d("[STATE]","STOPED")
    }

    override fun onDestroy() {
        Log.d("[STATE]","DESTROYED")
        super.onDestroy()
    }*/

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
