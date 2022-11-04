package com.example.beep.data

data class SignUpInput(
    val fcmToken: String,
    val password: String,
    val phoneNumber: String
)