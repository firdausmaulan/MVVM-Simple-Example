package com.firdaus.example.ui.user

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.firdaus.example.R
import com.firdaus.example.base.BaseActivity
import com.firdaus.example.databinding.ActivityUserBinding
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : BaseActivity(), EventListener {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val binding: ActivityUserBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_user
        )
        userViewModel.setBaseEventListener(this)
        binding.userViewModel = userViewModel
        binding.event = this
        binding.lifecycleOwner = this
    }

    override fun onButtonSubmitClicked() {
        userViewModel.changeUserName(etFirstName.text.toString(), etLastName.text.toString())
    }
}
