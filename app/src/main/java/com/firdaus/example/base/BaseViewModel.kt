package com.firdaus.example.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private lateinit var baseEvent: BaseEventListener

    fun setBaseEventListener(baseEventListener: BaseEventListener) {
        baseEvent = baseEventListener
    }

    fun showBaseLoading() {
        baseEvent.showBaseLoading()
    }

    fun hideBaseLoading() {
        baseEvent.hideBaseLoading()
    }

    fun showMessage(message: String?) {
        baseEvent.showMessage(message)
    }
}
