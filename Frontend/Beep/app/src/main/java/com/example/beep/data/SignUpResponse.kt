package com.example.beep.data

data class SignUpResponse(
    val alarm: Int,
    val authority: String,
    val blockList: List<Any>,
    val engrave: Any,
    val fcmToken: String,
    val font: Int,
    val id: Int,
    val introduceAudio: Any,
    val password: String,
    val phoneBookList: List<Any>,
    val phoneNumber: String,
    val presetList: List<Any>,
    val theme: Int
)