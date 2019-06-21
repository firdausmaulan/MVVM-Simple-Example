package com.firdaus.example.base

import android.content.Context
import android.support.multidex.MultiDexApplication

class BaseApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        val context: Context
            get() = instance?.applicationContext as Context

        @get:Synchronized
        var instance: BaseApp? = null
            private set
    }
}