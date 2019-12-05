package com.firdaus.example.utils

import android.util.Log
import com.firdaus.example.BuildConfig

object LogUtil {

    private const val TAG = "MVVM Example"

    fun v(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.v(tag, message)
    }

    fun v(message: String) {
        if (BuildConfig.DEBUG) Log.v(TAG, message)
    }

    fun d(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.d(tag, message)
    }

    fun d(message: String) {
        if (BuildConfig.DEBUG) Log.d(TAG, message)
    }

    fun i(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.i(tag, message)
    }

    fun i(message: String) {
        if (BuildConfig.DEBUG) Log.i(TAG, message)
    }

    fun e(tag: String, message: String) {
        if (BuildConfig.DEBUG) Log.e(tag, message)
    }

    fun e(message: String) {
        if (BuildConfig.DEBUG) Log.e(TAG, message)
    }
}