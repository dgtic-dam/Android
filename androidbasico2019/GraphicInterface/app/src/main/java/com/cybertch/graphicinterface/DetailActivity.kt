package com.cybertch.graphicinterface

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cybertch.graphicinterface.model.Student

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val student=intent.extras.getSerializable("student") as Student
        Log.d("test","Hola")
    }
}
