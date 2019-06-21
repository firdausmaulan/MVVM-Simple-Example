package com.firdaus.example.dataSource.remote.repositoryProfile

import android.annotation.SuppressLint
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.model.profile.ProfileResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class RepositoryProfile {

    private val service = ApiServiceProfile.create()

    fun requestProfile(callback: RepositoryCallback<ProfileResponse>) {
        service.requestProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<ProfileResponse>() {
                override fun onSuccess(response: ProfileResponse) {
                    callback.onDataLoaded(response)
                    dispose()
                }

                override fun onError(error: Throwable) {
                    callback.onDataError(error = error.message.toString())
                    dispose()
                }
            })
    }
}