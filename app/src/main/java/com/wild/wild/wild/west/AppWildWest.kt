package com.wild.wild.wild.west

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class AppWildWest : Application(){

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var contextWildWest: Context
    }

    override fun onCreate() {
        super.onCreate()

        contextWildWest = applicationContext
    }
}