package com.firdaus.example.model.user

data class User(
    var firstName: String? = null,
    var lastName: String? = null,
    var firstNameError: Int? = null,
    var lastNameError: Int? = null
)