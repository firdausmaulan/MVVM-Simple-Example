package com.firdaus.example.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firdaus.example.R
import com.firdaus.example.ui.news.NewsActivity
import com.firdaus.example.ui.profile.ProfileActivity
import com.firdaus.example.ui.user.UserActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnUser.setOnClickListener {
            startActivity<UserActivity>()
        }

        btnProfile.setOnClickListener {
            startActivity<ProfileActivity>()
        }

        btnNews.setOnClickListener {
            startActivity<NewsActivity>()
        }
    }
}