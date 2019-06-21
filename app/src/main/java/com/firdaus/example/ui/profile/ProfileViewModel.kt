package com.firdaus.example.ui.profile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile
import com.firdaus.example.model.profile.Profile
import com.firdaus.example.model.profile.ProfileResponse

class ProfileViewModel : ViewModel() {

    private val _profile = MutableLiveData<Profile>()
    private val repository = RepositoryProfile()

    val profile: LiveData<Profile>
        get() = _profile

    fun requestProfile() {
        repository.requestProfile(object : RepositoryCallback<ProfileResponse> {
            override fun onDataLoaded(response: ProfileResponse) {
                _profile.value = response.profile
            }

            override fun onDataError(error: String?) {

            }
        })
    }
}