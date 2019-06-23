package com.firdaus.example.ui.news

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firdaus.example.dataSource.remote.repositoryNews.RepositoryNews
import com.firdaus.example.databinding.ActivityNewsBinding
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        newsViewModel = ViewModelProviders
                .of(this, NewsFactory(RepositoryNews()))
                .get(NewsViewModel::class.java)
        val binding = ActivityNewsBinding.inflate(layoutInflater)
        binding.newsViewModel = newsViewModel
        binding.setLifecycleOwner(this)
        setContentView(binding.root)

        rvNews.adapter = NewsAdapter()
        newsViewModel.requestNews(1)
    }
}
