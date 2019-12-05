package com.firdaus.example.ui.news

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.firdaus.example.R
import com.firdaus.example.base.BaseActivity
import com.firdaus.example.dataSource.remote.repositoryNews.RepositoryNews
import com.firdaus.example.databinding.ActivityNewsBinding
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : BaseActivity() {

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        newsViewModel = ViewModelProviders
            .of(this, NewsFactory(RepositoryNews()))
            .get(NewsViewModel::class.java)
        newsViewModel.setBaseEventListener(this)
        val binding: ActivityNewsBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_news
        )
        binding.newsViewModel = newsViewModel
        binding.lifecycleOwner = this

        rvNews.adapter = NewsAdapter()
        newsViewModel.requestNews(1)
    }
}
