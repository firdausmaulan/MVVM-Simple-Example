package com.firdaus.example.model.profile

data class ProfileResponse(
    val message: String,
    val profile: Profile,
    val success: Boolean
)