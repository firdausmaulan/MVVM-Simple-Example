package com.firdaus.example.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firdaus.example.dataSource.remote.repositoryNews.RepositoryNews
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile

class NewsFactory(private val repository: RepositoryNews) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }
}