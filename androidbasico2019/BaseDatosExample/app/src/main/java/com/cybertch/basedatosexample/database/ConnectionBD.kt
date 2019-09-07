package com.cybertch.basedatosexample.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext


/**
 * Description:
 *
 * Project: BaseDatosExample
 * Package: com.cybertch.basedatosexample.database
 * @author: Jaive Torres Pineda
 * dateCreated: 2019-07-30
 * dateLastModified:
 * @version:
 * @since:
 *
 **/

class ConnectionBD (context: Context): SQLiteOpenHelper(
    context,
    BD_NAME,
    null,VERSION_BD
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_USER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_USER)
    }

    fun openConection(typeConnectionBD: Int):SQLiteDatabase{
        return when (typeConnectionBD) {
            MODE_WRITE ->
                return writableDatabase
            MODE_READ ->
                return readableDatabase
            else->
                return readableDatabase
        }
    }

    companion object{
        const val BD_NAME="users"
        const val VERSION_BD=1
        const val TABLE_NAME="users"
        const val CREATE_TABLE_USER="CREATE TABLE users(id INTEGER PRIMARY KEY, name VARCHAR(30), " +
                "lastname VARCHAR(60), age INT, numberphone VARCHAR(10), email VARCHAR(100))"
        const val DROP_TABLE_USER="DROP TABLE IF EXISTS users"
        const val MODE_WRITE=1
        const val MODE_READ=2
    }
}
