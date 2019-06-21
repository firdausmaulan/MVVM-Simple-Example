package com.firdaus.example.ui.user

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.firdaus.example.databinding.ActivityUserBinding
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private var clickHandlers = ClickHandlers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val binding = ActivityUserBinding.inflate(layoutInflater)
        binding.userViewModel = userViewModel
        binding.userClickHandlers = clickHandlers
        binding.setLifecycleOwner(this)
        setContentView(binding.root)
    }

    inner class ClickHandlers {
        fun changeUserName(view: View) {
            userViewModel.changeUserName(
                    etFirstName.text.toString(),
                    etLastName.text.toString()
            )
        }
    }
}
