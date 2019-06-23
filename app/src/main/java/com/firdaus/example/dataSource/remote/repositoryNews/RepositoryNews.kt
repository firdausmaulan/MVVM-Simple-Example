package com.firdaus.example.dataSource.remote.repositoryNews

import android.annotation.SuppressLint
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.model.news.News
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class RepositoryNews {

    private val service = ApiServiceNews.create()

    fun requestNews(page: Int?, callback: RepositoryCallback<News>) {
        service.requestNews(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<News>() {
                override fun onSuccess(response: News) {
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