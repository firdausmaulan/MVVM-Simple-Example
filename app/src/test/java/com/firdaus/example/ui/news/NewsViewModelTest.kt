package com.firdaus.example.ui.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.firdaus.example.base.BaseEventListener
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.dataSource.remote.repositoryNews.RepositoryNews
import com.firdaus.example.model.news.News
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NewsViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: RepositoryNews


    @Mock
    private lateinit var viewModel: NewsViewModel

    @Mock
    private lateinit var baseEventListener: BaseEventListener

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = NewsViewModel(repository)
        viewModel.setBaseEventListener(baseEventListener)
    }

    @Test
    fun requestNews() {
        // Params
        val page = 1
        // Response
        val status = "ok"
        val response = News(status = status)
        viewModel.requestNews(page)
        argumentCaptor<RepositoryCallback<News>>().apply {
            verify(repository).requestNews(eq(page), capture())
            firstValue.onDataLoaded(response)
        }
        Assert.assertNotNull(response)
        Assert.assertEquals(response.status, status)
    }
}