package com.example.pointer.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private var mySharedPref: SharedPreferences =
        context.getSharedPreferences("filename", Context.MODE_PRIVATE)

    fun setLang(lang: String?) {
        val editor = mySharedPref.edit()
        editor.putString("lang", lang)
        editor.apply()
    }

    fun getLang(): String? {
        return mySharedPref.getString("lang", "uz")
    }


    fun setBoolean(boolean: Boolean?) {
        val editor = mySharedPref.edit()
        editor.putBoolean("pointer", boolean!!)
        editor.commit()
    }

    fun getBoolean(): Boolean? {
        return mySharedPref.getBoolean("pointer", false)
    }
}