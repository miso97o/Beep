package com.example.beep.data

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("accessToken") val accessToken:String,
)