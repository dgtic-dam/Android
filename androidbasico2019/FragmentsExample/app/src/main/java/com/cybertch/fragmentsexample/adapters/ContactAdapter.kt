package com.cybertch.fragmentsexample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cybertch.fragmentsexample.R
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*
import kotlin.contracts.ContractBuilder


class ContactAdapter(
    val contacts:ArrayList<Contact>, val context: Context?): RecyclerView.Adapter<ContactViewHolder>(){

    private var onItemContactSelectedListener:(contact:Contact)->Unit={}

 //   private lateinit var onItemContactSelectedListener: OnItemContactSelectedListener

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

    public fun setOnItemContactSelected(listener: (Contact)->Unit){
        this.onItemContactSelectedListener=listener
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

   /* fun setOnItemContactSelectedListener(onItemContactSelectedListener: OnItemContactSelectedListener){
        this.onItemContactSelectedListener=onItemContactSelectedListener
    }*/
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

    fun setOnItemContactSelectedListener(listener:(contact:Contact)->Unit){
        itemView.setOnClickListener{listener(contact)}
    }
}