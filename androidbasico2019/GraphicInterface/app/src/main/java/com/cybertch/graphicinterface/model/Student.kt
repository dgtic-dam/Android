package com.cybertch.graphicinterface.model

import java.io.Serializable
import java.net.Inet4Address

/*class Student {
}
*/
data class Student(var id:Int=0,
                   var name:String="",
                   var lastname:String="",
                   var age:Int=0,
                   var sex:Char='F',
                   var address: String="",
                   var state:String="",
                   var topics:ArrayList<String>,
                   var email:String="",
                   var phoneNumber:String=""):Serializable{ //data class, es propia de kotiln
//Data class genera una clase que cumpla con un Bean
    constructor():
        this(0,"","",0,'F',"", "", arrayListOf<String>() ,"", "") //constructor secundario
}