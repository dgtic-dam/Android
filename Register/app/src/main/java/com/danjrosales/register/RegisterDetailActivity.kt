package com.danjrosales.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danjrosales.register.model.Client
import kotlinx.android.synthetic.main.activity_register_detail.*
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class RegisterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_detail)

        val client = intent.extras?.getSerializable("client") as Client
        Log.d("test", "Hola")

        fullNameTtextView.text = client.name + " " + client.lastname
        emailTextView.text = client.email
        preftextView.text = arrayListOf(client.pref).toString()
        noticeTextView.text = client.notice
    }
}
