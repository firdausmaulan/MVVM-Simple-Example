package com.firdaus.example.ui.profile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.firdaus.example.R
import com.firdaus.example.base.BaseActivity
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile
import com.firdaus.example.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        profileViewModel = ViewModelProviders
            .of(this, ProfileFactory(RepositoryProfile()))
            .get(ProfileViewModel::class.java)
        profileViewModel.setBaseEventListener(this)
        val binding: ActivityProfileBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_profile
        )
        binding.profileViewModel = profileViewModel
        binding.lifecycleOwner = this
        profileViewModel.requestProfile()
    }
}
