package com.cybertch.basedatosexample.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.cybertch.basedatosexample.model.User


/**
 * Description:
 *
 * Project: BaseDatosExample
 * Package: com.cybertch.basedatosexample.database
 * @author: Jaive Torres Pineda
 * dateCreated: 2019-08-06
 * dateLastModified:
 * @version:
 * @since:
 *
 **/
class Database {

    private lateinit var connectionBD: ConnectionBD
    private lateinit var sqliteDatabase: SQLiteDatabase

    constructor(context: Context) {
        connectionBD = ConnectionBD(context)
        sqliteDatabase = connectionBD.openConection(ConnectionBD.MODE_WRITE)
    }

    fun registerUser(user: User): Boolean {
        val values = ContentValues() //ContentValues similar a Bundle, es un mapa de objetos para insertar datos
       // values.put(ID, user.id) //Llave, valor
        values.put(NAME, user.name)
        values.put(LASTNAME, user.lastname)
        values.put(AGE, user.age)
        values.put(NUMBERPHONE, user.numberPhone)
        values.put(EMAIL, user.email)
        val insert = sqliteDatabase.insert(ConnectionBD.TABLE_NAME, null, values)
        return insert > 0 //error regresa -1
    }

    fun deleteUser(idUser: Int): Boolean {
        val values = arrayOf(idUser.toString()) //id se convierte a cadena, se genera un arreglo
        val selection = "id like ?"
        val delete = sqliteDatabase.delete(ConnectionBD.TABLE_NAME, selection, values)
        /*var sql="delete from users where id="+idUser
        sqliteDatabase.execSQL(sql)*/
        return delete > 0
    }

    fun modifyUser(user: User): Boolean {
        val values = ContentValues()
        values.put(ID, user.id)
        values.put(NAME, user.name)
        values.put(LASTNAME, user.lastname)
        values.put(AGE, user.age)
        values.put(NUMBERPHONE, user.numberPhone)
        values.put(EMAIL, user.email)
        val selection = "id=?"
        val args = arrayOf(user.id.toString())
        val updated = sqliteDatabase.update(ConnectionBD.TABLE_NAME, values, selection, args)
        return updated > 0
    }

    fun getAllUsers(): ArrayList<User> {
        val users = ArrayList<User>()
        val fields = arrayOf("id", "name", "lastname", "age", "numberphone", "email")
        val cursor = sqliteDatabase.query(
            ConnectionBD.TABLE_NAME, fields, null, null,
            null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                users.add(
                    User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getString(5)
                    )
                )
            } while (cursor.moveToNext())
        }
        return users
    }

    fun getUser(id: Int): User? {
        var user: User? = null
        val fields = arrayOf("id", "name", "lastname", "age", "numberphone", "email")
        val args = arrayOf(id.toString())
        val cursor = sqliteDatabase.query(
            ConnectionBD.TABLE_NAME, fields, "id=?", args,
            null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                user = User(
                    cursor.getInt(0),
                    //cursor.getInt(cursor.getColumnIndex())
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5)
                )
            } while (cursor.moveToNext())
        }
        return user
    }

    fun closeDB(){
        if(sqliteDatabase!=null)
            sqliteDatabase.close()
    }

    companion object { //id de la tabla
        const val ID = "id"
        const val NAME = "name"
        const val LASTNAME = "lastname"
        const val AGE = "age"
        const val NUMBERPHONE = "numberphone"
        const val EMAIL = "email"
    }
}