package com.cybertch.recyclerviewexample.adapter

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.cybertch.recyclerviewexample.R
import com.cybertch.recyclerviewexample.listener.OnItemContactSelectedListener
import com.cybertch.recyclerviewexample.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*
import java.text.FieldPosition


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
class ContactAdapter(
    val contacts:ArrayList<Contact>,
    val context: Context
): RecyclerView.Adapter<ContactViewHolder>(){

    private lateinit var onItemContactSelectedListener: OnItemContactSelectedListener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_contact,
                p0,
                false
            )
        )
    } //Retorna la vista para agregarla al contexto

    override fun getItemCount(): Int { // Regresa tamaño de la vista
        return contacts.size
    }

    override fun onBindViewHolder(p0: ContactViewHolder, p1: Int) {
        p0.numberphoneButton.setImageResource(android.R.drawable.sym_action_call)
        p0.contactImageView.setImageResource(R.mipmap.ic_launcher)
        p0.nameTextView.setText(contacts[p1].name)
        p0.lastNameTextView.setText(contacts[p1].lastname)
        p0.setContact(contacts[p1])
        p0.setOnItemContactSelectedListener(onItemContactSelectedListener)
    }

    public fun addContact(contact: Contact, position: Int){ //Agregar nuevos elementos a la lista
            contacts.add(position, contact)
        //notifyDataSetChanged() // Notifica a la lista
        notifyItemInserted(position) //Inserta en una posición
    }

    public fun removeContact(position: Int){ //Agregar nuevos elementos a la lista
        contacts.removeAt(position)
        notifyDataSetChanged() // Notifica a la lista
        notifyItemRemoved(position)
    }

    fun setOnItemContactSelectedListener(onItemContactSelectedListener: OnItemContactSelectedListener){
        this.onItemContactSelectedListener=onItemContactSelectedListener
    }
}

class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
    val contactImageView=view.contact_imageView
    val nameTextView=view.name_textView
    val lastNameTextView=view.lastname_textView
    val numberphoneButton=view.numberPhone_imageButton
    private lateinit var contact: Contact

    fun setContact(contact: Contact){
        this.contact=contact
    }

    fun setOnItemContactSelectedListener(onItemContactSelectedListener: OnItemContactSelectedListener){
        if(onItemContactSelectedListener!=null)
            itemView.setOnClickListener{onItemContactSelectedListener.onItemContactSelected(contact)}
    }
}