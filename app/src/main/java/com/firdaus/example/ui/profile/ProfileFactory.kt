package com.firdaus.example.ui.profile

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile

class ProfileFactory(private val repository: RepositoryProfile) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}