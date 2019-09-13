package com.danjrosales.register.model;

import java.io.Serializable

data class Client(
    var id: Int = 0,
    var name: String = "",
    var lastname: String = "",
    var email: String = "",
    var password: String = "",
    var sex: String = "O",
    var pref: ArrayList<String>,
    var notice: String = ""
) : Serializable {
    constructor() :
            this(0, "", "", "", "", "", arrayListOf<String>(), "") //constructor secundario
}