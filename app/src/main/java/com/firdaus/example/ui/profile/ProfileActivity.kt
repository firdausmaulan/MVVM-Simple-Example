package com.firdaus.example.ui.profile

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile
import com.firdaus.example.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        profileViewModel = ViewModelProviders
            .of(this, ProfileFactory(RepositoryProfile()))
            .get(ProfileViewModel::class.java)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        binding.profileViewModel = profileViewModel
        binding.setLifecycleOwner(this)
        setContentView(binding.root)

        profileViewModel.requestProfile()
    }
}
