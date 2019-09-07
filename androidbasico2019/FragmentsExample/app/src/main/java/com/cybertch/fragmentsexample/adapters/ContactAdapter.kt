package com.cybertch.fragmentsexample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cybertch.fragmentsexample.R
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*


/**
 * Description:
 *
 * Project: FragmentsExample
 * Package: com.cybertch.fragmentsexample.adapters
 * @author: Jaive Torres Pineda
 * dateCreated: 2019-07-28
 * dateLastModified:
 * @version:
 * @since:
 *
 **/
class ContactAdapter (val contacts:ArrayList<Contact>, val context: Context): RecyclerView.Adapter<ContactViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
    return ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false))
  }

  override fun getItemCount(): Int {
    return contacts.size
  }

  override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
    holder.nameTextView?.text=contacts.get(position).name
    holder.lastNameTextView?.text=contacts.get(position).lastname
  }
}

class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
  val nameTextView=view.name_textView
  val lastNameTextView=view.lastname_textView
}