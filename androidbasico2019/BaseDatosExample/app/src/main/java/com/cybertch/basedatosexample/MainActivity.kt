package com.cybertch.basedatosexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.cybertch.basedatosexample.database.Database
import com.cybertch.basedatosexample.model.User

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.security.acl.LastOwnerException

class MainActivity : AppCompatActivity() {

    private lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            saveUser()
        }
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

    override fun onStop(){
        if (database!=null)
            database.closeDB()
        super.onStop()
    }

    fun saveUser(){
        val name = name_textInputLayout.editText?.text.toString()
        val lastname = lastname_textInputLayout.editText?.text.toString()
        val age = age_textInputLayout.editText?.text.toString().toInt()
        val sex = sexSelected()
        var numberPhone = number_phone_textInputLayout.editText?.text.toString()
        var email = email_textInputLayout.editText?.text.toString()

        database=Database(baseContext)
        if(database.registerUser(User(name,lastname,age,numberPhone,email))){
            Toast.makeText(baseContext, "Se registro", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(baseContext, "No se registró", Toast.LENGTH_LONG).show()
        }
    }

    fun sexSelected():Char{
        if(male_checkedTextView.isChecked){
            return 'M'
        }else if(female_checkedTextViewx.isChecked){
            return 'F'
        }else{
            return 'F'
        }
    }
}
