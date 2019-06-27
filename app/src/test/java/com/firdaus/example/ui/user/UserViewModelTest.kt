package com.firdaus.example.ui.user

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class UserViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: UserViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = UserViewModel()
    }

    @Test
    fun changeUserName() {

    }
}