package com.firdaus.example.ui.news

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.dataSource.remote.repositoryNews.RepositoryNews
import com.firdaus.example.model.news.News

class NewsViewModel constructor(private val repository: RepositoryNews) : ViewModel() {

    private val _news = MutableLiveData<News>()

    val news: LiveData<News>
        get() = _news

    fun requestNews(page: Int) {
        repository.requestNews(page, object : RepositoryCallback<News> {
            override fun onDataLoaded(response: News) {
                _news.value = response
            }

            override fun onDataError(error: String?) {

            }
        })
    }

}