package com.cybertch.fragmentsexample.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cybertch.fragmentsexample.R
import com.cybertch.fragmentsexample.model.Contact
import kotlinx.android.synthetic.main.fragment_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_CONTACT_PARAM = "contactParam"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
  // TODO: Rename and change types of parameters
  private var contact: Contact? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      contact = it.getSerializable(ARG_CONTACT_PARAM) as Contact
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    nametextView.text=contact?.name
    lastNametextView.text=contact?.lastname
    }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_detail, container, false)
  }


  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(contact: Contact) =
      DetailFragment().apply {
        arguments = Bundle().apply {
         putSerializable(ARG_CONTACT_PARAM, contact)
        }
      }
  }
}
