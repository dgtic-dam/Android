package com.cybertch.graphicinterface

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.cybertch.graphicinterface.model.Student
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    /*
     private lateinit var nameTextInputLayout:TextInputLayout //lateinit: todas las variables se tienen que settear pero despues, equivalente a lazy
     private lateinit var lastnameTextInputLayout:TextInputLayout
     private lateinit var ageTextInputLayout:TextInputLayout
     private lateinit var addressTextInputLayout:TextInputLayout
     private lateinit var emailTextInputLayout:TextInputLayout
     private lateinit var numberPhoneTextInputLayout:TextInputLayout
     private lateinit var sexRadioGroup:RadioGroup
     private lateinit var stateSpinner:Spinner
     private lateinit var historyCheckedTextView: CheckedTextView
     private lateinit var geographyCheckedTextView: CheckedTextView
     private lateinit var philosophyCheckedTextView: CheckedTextView
     private lateinit var mathematicsCheckedTextView: CheckedTextView
     private lateinit var spanishCheckedTextView: CheckedTextView
     private lateinit var languagesCheckedTextView: CheckedTextView
     private lateinit var saveFloatingActionButton: FloatingActionButton
     */
    private val student: Student= Student()
    //Checked Text View
    private val topics = ArrayList<String>() //Arreglo para guardar CheckedTextViews

    private val onCheckedTopicsChangeListener: CompoundButton.OnCheckedChangeListener =
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            saveTopicSelected(isChecked, buttonView.text.toString())
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        spanishCheckedTextView.setOnCheckedChangeListener(onCheckedTopicsChangeListener)
        mathematicsCheckedTextView.setOnCheckedChangeListener(onCheckedTopicsChangeListener)
        historyCheckedTextView.setOnCheckedChangeListener(onCheckedTopicsChangeListener)
        philosophyCheckedTextView.setOnCheckedChangeListener(onCheckedTopicsChangeListener)
        geographyCheckedTextView.setOnCheckedChangeListener(onCheckedTopicsChangeListener)
        languagesCheckedTextView.setOnCheckedChangeListener(onCheckedTopicsChangeListener)

        nameTextInputLayout.editText?.setOnFocusChangeListener{ view,hasfocus ->
            if(!hasfocus){
                //  val name:String = nametextInputLayout.editText?.text.toString()
                val name = nameTextInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if(name.isNotEmpty()){
                    nameTextInputLayout.isErrorEnabled=false
                }else{
                    nameTextInputLayout.isErrorEnabled = false
                    nameTextInputLayout.error="El nombre es incorrecto"
                }
            }
        }//Para no aceptar nulos TextInputLayout

        lastnameTextInputLayout.editText?.setOnFocusChangeListener{ view,hasfocus ->
            if(!hasfocus){
                val name = lastnameTextInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if(name.isNotEmpty()){
                    lastnameTextInputLayout.isErrorEnabled=false
                }else{
                    lastnameTextInputLayout.isErrorEnabled = false
                    lastnameTextInputLayout.error="El apellido es incorrecto"
                }
            }
        }

        ageTextInputLayout.editText?.setOnFocusChangeListener{ view,hasfocus ->
            if(!hasfocus){
                val name = ageTextInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if(name.isNotEmpty()){
                    ageTextInputLayout.isErrorEnabled=false
                }else{
                    ageTextInputLayout.isErrorEnabled = false
                    ageTextInputLayout.error="La edad es incorrecto"
                }
            }
        }
        addressTextInputLayout.editText?.setOnFocusChangeListener{ view,hasfocus ->
            if(!hasfocus){
                val name = addressTextInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if(name.isNotEmpty()){
                    addressTextInputLayout.isErrorEnabled=false
                }else{
                    addressTextInputLayout.isErrorEnabled = false
                    addressTextInputLayout.error="La dirección es incorrecto"
                }
            }
        }

        emailTextInputLayout.editText?.setOnFocusChangeListener{ view,hasfocus ->
            if(!hasfocus){
                val name = emailTextInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if(name.isNotEmpty()){
                    emailTextInputLayout.isErrorEnabled=false
                }else{
                    emailTextInputLayout.isErrorEnabled = false
                    emailTextInputLayout.error="El email es incorrecto"
                }
            }
        }

        numberphoneTextInputLayout.editText?.setOnFocusChangeListener{ view,hasfocus ->
            if(!hasfocus){
                val name = numberphoneTextInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if(name.isNotEmpty()){
                    numberphoneTextInputLayout.isErrorEnabled=false
                }else{
                    numberphoneTextInputLayout.isErrorEnabled = false
                    numberphoneTextInputLayout.error="El número telefónico es incorrecto"
                            }
                        }
                    }

                    sexRadioGroup.setOnCheckedChangeListener{group, checkedId ->
                        //var sexSelector='M' //mutable, lambda cuando es de un solo método
                        when(checkedId){
                            /*  maleRadioButton.id -> sexSelector = 'M'
                              femaleRadioButton.id -> sexSelector = 'F'
                              */
                            maleRadioButton.id -> student.sex = 'M'
                            femaleRadioButton.id -> student.sex = 'F'
                        }
                    }
                    val states = arrayListOf<String>("Aguascalientes", "Baja California Norte", "CDMX") // Dinámico
                    //val states = resources.getStringArray(R.array.states) // Estático
                    val statesAdapter = ArrayAdapter<String>(baseContext,android.R.layout.simple_spinner_item, states)
                    statesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                    stateSpinner.adapter=statesAdapter

                    stateSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener { //Varios métodos

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {

                            //val stateSelected=states[position]
                            student.state=states[position]
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            student.state=states[0]
                        }
                    }

                    save_floatingActionButton.setOnClickListener{view:View->
                        Toast.makeText(baseContext, "Se guardo la información", Toast.LENGTH_LONG).show()
                        student.id=1
                        student.name = nameTextInputLayout.editText?.text.toString()
                        student.lastname = lastnameTextInputLayout.editText?.text.toString()
                        student.age = ageTextInputLayout.editText?.text.toString().toInt()
                        student.address = addressTextInputLayout.editText?.text.toString()
                        student.email = emailTextInputLayout.editText?.text.toString()
                        student.phoneNumber = numberphoneTextInputLayout.editText?.text.toString()

                        var detailIntent=Intent(this, DetailActivity::class.java)
                        detailIntent.putExtra("student",student)
                        startActivity(detailIntent)
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

        private fun saveTopicSelected(isChecked:Boolean, topic:String ){
            if(isChecked){
                student.topics.add(topic)
            }else{
                student.topics.remove(topic)
            }
        }

        /*  private fun checkViewValidation(isChecked:Boolean, topic:String ){
              if(isChecked){
                  student.topics.add(topic)
              }else{
                  student.topics.remove(topic)
              }
          }*/

        private fun sendInformation(){

        }
    }
