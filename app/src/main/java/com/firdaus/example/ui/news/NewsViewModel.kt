package com.firdaus.example.ui.news

import androidx.lifecycle.MutableLiveData
import com.firdaus.example.base.BaseViewModel
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.dataSource.remote.repositoryNews.RepositoryNews
import com.firdaus.example.model.news.News
import com.firdaus.example.utils.LogUtil

class NewsViewModel constructor(private val repository: RepositoryNews) : BaseViewModel() {

    val newsLiveData = MutableLiveData<News>()

    fun requestNews(page: Int) {
        showBaseLoading()
        repository.requestNews(page, object : RepositoryCallback<News> {
            override fun onDataLoaded(response: News) {
                hideBaseLoading()
                newsLiveData.value = response
            }

            override fun onDataError(error: String?) {
                hideBaseLoading()
                LogUtil.e(error.toString())
                showMessage(error)
            }
        })
    }

}