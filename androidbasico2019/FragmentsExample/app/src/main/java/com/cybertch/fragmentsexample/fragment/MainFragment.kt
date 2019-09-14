package com.cybertch.fragmentsexample.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cybertch.fragmentsexample.DetailActivity

import com.cybertch.fragmentsexample.R
import com.cybertch.fragmentsexample.adapters.ContactAdapter
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class MainFragment : Fragment() {
  // TODO: Rename and change types of parameters
 /* private var param1: String? = null
  private var param2: String? = null*/
  private lateinit var contactAdapter: ContactAdapter
  private var isTablet=false

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    isTablet=resources.getBoolean(R.bool.is_tablet)
  /*  arguments?.let {
      param1 = it.getString(ARG_PARAM1)
      param2 = it.getString(ARG_PARAM2)
    }*/
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false) //ReverseLayout: Revertir elementos
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

    contactAdapter= ContactAdapter(contacts, context)
    contactAdapter.setOnItemContactSelected {
      if (isTablet){
        activity?.supportFragmentManager!!
          .beginTransaction()
          .replace(R.id.containerDetail, DetailFragment.newInstance(it)).commit()
      }else{
        val detailIntent=Intent(activity,DetailActivity::class.java)
        detailIntent.putExtra("contactParam", it)
        startActivity(detailIntent)
      }
    }
    contactsRecyclerView.adapter=contactAdapter
  }

  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance() = MainFragment()
 /*  fun newInstance(param1: String, param2: String) =
      MainFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_PARAM1, param1)
          putString(ARG_PARAM2, param2)
        }
      }*/
  }
}
