package com.firdaus.example.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firdaus.example.R
import com.firdaus.example.base.BaseViewModel
import com.firdaus.example.model.user.User

class UserViewModel : BaseViewModel() {

    val userLiveData = MutableLiveData<User>()

    /*init {
        userLiveData.value = User("Maulana", "Firdaus")
    }*/

    fun changeUserName(firstName: String?, lastName: String?) {
        val user = User()
        if (firstName.isNullOrEmpty()) {
            user.firstNameError = R.string.required_first_name
        } else if (lastName.isNullOrEmpty()) {
            user.lastNameError = R.string.required_last_name
        } else {
            user.firstName = firstName
            user.lastName = lastName
        }
        //userLiveData.postValue(user)
        userLiveData.value = user
    }
}