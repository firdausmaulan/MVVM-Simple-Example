package com.firdaus.example.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile

class ProfileFactory(private val repository: RepositoryProfile) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}