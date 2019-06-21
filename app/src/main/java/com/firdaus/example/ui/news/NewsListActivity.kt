package com.firdaus.example.ui.news

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class NewsListActivity : AppCompatActivity() {

    /*private lateinit var userViewModel: UserViewModel
    private var clickHandlers = ClickHandlers()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MVVM Initialization
        /*userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val binding = ActivityUserBinding.inflate(layoutInflater)
        binding.viewModel = userViewModel
        binding.clickHandlers = clickHandlers
        binding.setLifecycleOwner(this)
        setContentView(binding.root)*/
    }

    /*inner class ClickHandlers {
        fun onClickButtonChangeValue(view: View) {
            userViewModel.changeUserName()
        }

        fun onClickButtonOpenNewsPage(view: View) {
            startActivity<>()
        }
    }*/
}
