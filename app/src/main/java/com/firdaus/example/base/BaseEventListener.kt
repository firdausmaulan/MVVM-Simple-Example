package com.firdaus.example.base

interface BaseEventListener {
    fun showBaseLoading()
    fun hideBaseLoading()
    fun showMessage(message: String?)
}