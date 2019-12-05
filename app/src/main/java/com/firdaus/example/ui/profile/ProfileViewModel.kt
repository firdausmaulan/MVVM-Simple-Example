package com.firdaus.example.ui.profile

import androidx.lifecycle.MutableLiveData
import com.firdaus.example.base.BaseViewModel
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile
import com.firdaus.example.model.profile.Profile
import com.firdaus.example.model.profile.ProfileResponse
import com.firdaus.example.utils.LogUtil

class ProfileViewModel constructor(private val repository: RepositoryProfile) : BaseViewModel() {

    val profileLiveData = MutableLiveData<Profile>()

    fun requestProfile() {
        showBaseLoading()
        repository.requestProfile(object : RepositoryCallback<ProfileResponse> {
            override fun onDataLoaded(response: ProfileResponse) {
                hideBaseLoading()
                profileLiveData.value = response.profile
            }

            override fun onDataError(error: String?) {
                hideBaseLoading()
                LogUtil.e(error.toString())
                showMessage(error)
            }
        })
    }
}