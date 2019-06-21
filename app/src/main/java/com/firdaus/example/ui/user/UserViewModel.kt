package com.firdaus.example.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.firdaus.example.model.user.User

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()

    /*init {
        _user.value = User("Maulana", "Firdaus")
    }*/

    val user: LiveData<User>
        get() = _user

    fun changeUserName(firstName: String?, lastName: String?) {
        val user = User()
        if (firstName.isNullOrEmpty()) {
            user.requiredFirstName = "required first name"
        } else if (lastName.isNullOrEmpty()) {
            user.requiredLastName = "required last name"
        } else {
            user.firstName = firstName
            user.lastName = lastName
        }
        _user.value = user
    }
}