package com.example.brainviretest.repository

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class LocalPrefrances(val context: Context) {


    companion object {
        private val USER_PREFS = "LOCKATED_PREFS"
    }

    private var appSharedPrefs: SharedPreferences? = null
    private var prefsEditor: SharedPreferences.Editor? = null

      private val isLoggedOut = "LOG OUT"



    var logout: Boolean
        get() = appSharedPrefs!!.getBoolean(isLoggedOut, true)
        set(logout) {

            prefsEditor!!.putBoolean(isLoggedOut, logout).commit()
        }


    init {
        this.appSharedPrefs = context.getSharedPreferences(USER_PREFS, Activity.MODE_PRIVATE)
        this.prefsEditor = appSharedPrefs!!.edit()
    }


}