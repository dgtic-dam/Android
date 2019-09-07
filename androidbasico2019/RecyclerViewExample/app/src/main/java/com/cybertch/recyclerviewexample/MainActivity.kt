package com.cybertch.recyclerviewexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.cybertch.recyclerviewexample.adapter.ContactAdapter
import com.cybertch.recyclerviewexample.listener.OnItemContactSelectedListener
import com.cybertch.recyclerviewexample.model.Contact

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), OnItemContactSelectedListener {

    override fun onItemContactSelected(contact: Contact) {
        Toast.makeText(baseContext, contact.name, Toast.LENGTH_LONG).show()
    }

    //private lateinit var contactsRecyclerView:RecyclerView
    var idContact:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) //ReverseLayout: Revertir elementos
        contactsRecyclerView.layoutManager=linearLayoutManager
        contactsRecyclerView.setHasFixedSize(true)

        val contacts = arrayListOf<Contact>(Contact(1,"Daniel","Rosales","55665321"),
            Contact(2,"Liliana","Herrera", "54556789"),
            Contact(3,"Jaive", "Sanchez", "55443356"),
            Contact(4,"Manuel", "Sanchez", "55443356"),
            Contact(5,"Pedro", "Morales", "55443356"),
            Contact(6,"Maria", "Rojas", "55443356"),
            Contact(7,"Mario", "Vilchis", "55443356"),
            Contact(8,"Luis", "Romero", "55443356"),
            Contact(9,"Luisa", "Obrador", "55443356"),
            Contact(10,"Fabian", "Ebrad", "55443356"))

        val contactAdapter: ContactAdapter= ContactAdapter(contacts, baseContext)
        contactAdapter.setOnItemContactSelectedListener(this)
        contactsRecyclerView.adapter=contactAdapter

        fab.setOnClickListener { view ->
          /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
            contactAdapter.addContact(Contact(11,"Ricardo","Moreno","54442234"),2)
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
}
