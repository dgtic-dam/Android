package com.cybertch.recyclerviewexample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cybertch.recyclerviewexample.R
import com.cybertch.recyclerviewexample.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*


/**
 * Description:
 *
 * Project: RecyclerViewExample
 * Package: com.cybertch.recyclerviewexample.adapter
 * @author: Jaive Torres Pineda
 * dateCreated: 2019-07-23
 * dateLastModified:
 * @version:
 * @since:
 *
 **/
class ContactAdapter(val contacts:ArrayList<Contact>,val context: Context):
    RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact,p0, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(p0: ContactViewHolder, p1: Int) {
        p0?.nameTextView?.text=contacts.get(p1).name
        p0?.lastNameTextView?.text=contacts.get(p1).lastname
    }
}

class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
    val nameTextView=view.name_textView
    val lastNameTextView=view.lastname_textView
}

/*class ContactAdapter (val contacts:ArrayList<Contact>,val context: Context): RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder?.nameTextView?.text=contacts.get(position).name
        holder?.lastNameTextView?.text=contacts.get(position).lastname
    }
}*/

/*class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
    val nameTextView=view.name_textView
    val lastNameTextView=view.lastname_textView
}*/