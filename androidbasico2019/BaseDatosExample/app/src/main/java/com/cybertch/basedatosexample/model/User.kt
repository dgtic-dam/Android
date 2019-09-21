package com.cybertch.basedatosexample.model


/**
 * Description:
 *
 * Project: BaseDatosExample
 * Package: com.cybertch.basedatosexample.model
 * @author: Jaive Torres Pineda
 * dateCreated: 2019-08-06
 * dateLastModified:
 * @version:
 * @since:
 *
 **/
data class User(var id:Int,
                var name:String,
                var lastname:String,
                var age:Int,
                var numberPhone:String,
                var email:String){

    constructor(name:String,
                lastname:String,
                age:Int,
                numberPhone:String,
                email:String):this(0,name,lastname, age, numberPhone, email)
}
