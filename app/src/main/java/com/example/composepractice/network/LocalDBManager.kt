package com.example.composepractice.network

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDBManager @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPref = context.getSharedPreferences("token",Context.MODE_PRIVATE)

    fun setToken(token : String) {
        sharedPref.edit().putString("token",token).apply()
    }

    fun getToken() : String? {
        return sharedPref.getString("token",null)
    }
}