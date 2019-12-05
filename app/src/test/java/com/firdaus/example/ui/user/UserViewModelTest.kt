package com.firdaus.example.ui.user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.firdaus.example.base.BaseEventListener
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

    @Mock
    private lateinit var baseEventListener: BaseEventListener

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = UserViewModel()
        viewModel.setBaseEventListener(baseEventListener)
    }

    @Test
    fun changeUserName() {

    }
}