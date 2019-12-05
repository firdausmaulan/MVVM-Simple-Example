package com.firdaus.example.base

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.firdaus.example.R
import com.firdaus.example.databinding.BaseLoadingBinding
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity(), BaseEventListener {

    private lateinit var baseViewModel: BaseViewModel
    private lateinit var baseLoading: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        baseViewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)
        baseViewModel.setBaseEventListener(this)
        initBaseLoading()
    }

    private fun initBaseLoading() {
        baseLoading = Dialog(this)
        baseLoading.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding: BaseLoadingBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.base_loading, null, false
        )
        baseLoading.setContentView(binding.root)
        baseLoading.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val window = baseLoading.window
        window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        window?.setGravity(Gravity.CENTER)
        baseLoading.setCancelable(false)
    }

    override fun showBaseLoading() {
        if (baseLoading.isShowing) baseLoading.dismiss()
        baseLoading.show()
    }

    override fun hideBaseLoading() {
        if (baseLoading.isShowing) baseLoading.dismiss()
    }

    override fun showMessage(message: String?) {
        Snackbar.make(window.decorView.rootView, message.toString(), Snackbar.LENGTH_SHORT).show()
    }
}
