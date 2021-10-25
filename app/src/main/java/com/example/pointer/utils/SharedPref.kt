package com.example.pointer.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private var mySharedPref: SharedPreferences =
        context.getSharedPreferences("filename", Context.MODE_PRIVATE)

    fun setLang(lang: String?) {
val editor=mySharedPref.edit()
//        editor.putString("")
    }
}