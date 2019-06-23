package com.firdaus.example.ui.profile

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.firdaus.example.dataSource.remote.RepositoryCallback
import com.firdaus.example.dataSource.remote.repositoryProfile.RepositoryProfile
import com.firdaus.example.model.profile.ProfileResponse
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ProfileUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: RepositoryProfile


    @Mock
    private lateinit var viewModel: ProfileViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = ProfileViewModel(repository)
    }

    @Test
    fun requestProfile() {
        val response = ProfileResponse(true)
        viewModel.requestProfile()
        argumentCaptor<RepositoryCallback<ProfileResponse>>().apply {
            verify(repository).requestProfile(capture())
            firstValue.onDataLoaded(response)
        }
        assertNotNull(response)
        assertEquals(response.success, true)
    }
}