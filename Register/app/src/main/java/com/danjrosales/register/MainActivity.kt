package com.danjrosales.register

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.Toast
import com.danjrosales.register.model.Client

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.util.Patterns



class MainActivity : AppCompatActivity() {

    private val client: Client = Client()
    //Checked Text View
    private val preference = ArrayList<String>() //Arreglo para guardar CheckedTextViews

    private val onCheckedPreferenceChangeListener: CompoundButton.OnCheckedChangeListener =
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            savePrefSelected(isChecked, buttonView.text.toString())
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        /*Begin*/

        checkBoxAccion.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxAdventure.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxComedy.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxDrama.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxRomance.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxSciFi.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxSuspence.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)
        checkBoxTerror.setOnCheckedChangeListener(onCheckedPreferenceChangeListener)

        nameInputLayout.editText?.setOnFocusChangeListener { view, hasfocus ->
            if (!hasfocus) {
                val name =
                    nameInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if (name.isNotEmpty()) {
                    nameInputLayout.isErrorEnabled = false
                } else {
                    nameInputLayout.isErrorEnabled = false
                    nameInputLayout.error = "El nombre es incorrecto"
                }
            }
        }

        lastNameInputLayout.editText?.setOnFocusChangeListener { view, hasfocus ->
            if (!hasfocus) {
                val lname =
                    lastNameInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if (lname.isNotEmpty()) {
                    lastNameInputLayout.isErrorEnabled = false
                } else {
                    lastNameInputLayout.isErrorEnabled = false
                    lastNameInputLayout.error = "El apellido es incorrecto"
                }
            }
        }

        emailInputLayout.editText?.setOnFocusChangeListener { view, hasfocus ->
            if (!hasfocus) {
                val eml =
                    emailInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if (!validarEmail(eml)) {
                    emailInputLayout.error = ("Error, debe ser de la forma: ejemplo@dominio.com")
                } else {
                    if (eml.isNotEmpty()) {
                        emailInputLayout.isErrorEnabled = false
                    } else {

                        emailInputLayout.isErrorEnabled = false
                        emailInputLayout.error = "El email es incorrecto"
                    }
                }

            }
        }
        passwordInputLayout.editText?.setOnFocusChangeListener { view, hasfocus ->
            if (!hasfocus) {
                val ps =
                    passwordInputLayout.editText?.text.toString() // está inferido el tipo de dato, no mutable
                if (ps.isNotEmpty()) {
                    passwordInputLayout.isErrorEnabled = false
                } else {
                    passwordInputLayout.isErrorEnabled = false
                    passwordInputLayout.error = "La dirección es incorrecto"
                }
            }
        }


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                /*  maleRadioButton.id -> sexSelector = 'M'
                  femaleRadioButton.id -> sexSelector = 'F'
                  */
                radioButtonF.id -> client.sex = "M"
                radioButtonM.id -> client.sex = "F"
                radioButtonO.id -> client.sex = "O"
            }
        }
        val notice = arrayListOf<String>("Redes Sociales", "Sitio web", "Periódico") // Dinámico
        //val states = resources.getStringArray(R.array.states) // Estático
        val statesAdapter =
            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, notice)
        statesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        noticeSpinner.adapter = statesAdapter

        noticeSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener { //Varios métodos

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    //val stateSelected=states[position]
                    client.notice = notice[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    client.notice = notice[0]
                }
            }

        /*Fin*/


        /* fab.setOnClickListener { view ->
             Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 .setAction("Action", null).show()
         }*/

        save_btn.setOnClickListener { view: View ->
            Toast.makeText(baseContext, "Se guardo la información", Toast.LENGTH_LONG).show()
            client.id = 1
            client.name = nameInputLayout.editText?.text.toString()
            client.lastname = lastNameInputLayout.editText?.text.toString()
            client.email = emailInputLayout.editText?.text.toString().toString()
            client.password = passwordInputLayout.editText?.text.toString()

            var detailIntent = Intent(this, RegisterDetailActivity::class.java)
            detailIntent.putExtra("client", client)
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

    private fun savePrefSelected(isChecked: Boolean, topic: String) {
        if (isChecked) {
            client.pref.add(topic)
        } else {
            client.pref.remove(topic)
        }
    }

    private fun validarEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }


}
