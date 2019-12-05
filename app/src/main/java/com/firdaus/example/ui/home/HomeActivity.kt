package com.firdaus.example.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.firdaus.example.R
import com.firdaus.example.base.BaseActivity
import com.firdaus.example.databinding.ActivityHomeBinding
import com.firdaus.example.ui.news.NewsActivity
import com.firdaus.example.ui.profile.ProfileActivity
import com.firdaus.example.ui.user.UserActivity
import org.jetbrains.anko.startActivity

class HomeActivity : BaseActivity(), EventListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_home
        )
        binding.event = this
    }

    override fun onButtonUserClicked() {
        startActivity<UserActivity>()
    }

    override fun onButtonProfileClicked() {
        startActivity<ProfileActivity>()
    }

    override fun onButtonNewsClicked() {
        startActivity<NewsActivity>()
    }
}