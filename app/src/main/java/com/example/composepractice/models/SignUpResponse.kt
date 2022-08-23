package com.example.composepractice.models

data class SignUpResponse(
    val customToken: String,
    var isAllDataAvailable: Boolean,
    val userInfo: UserInfo,
    var isProfileCompleted: Boolean = false

)