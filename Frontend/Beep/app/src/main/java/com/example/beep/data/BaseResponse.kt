package com.example.beep.data

import com.google.gson.annotations.SerializedName

data class BaseResponse<out T> (
    @SerializedName("success") val success: Boolean,            // 서버 로직 성공/실패 여부
    @SerializedName("data") val data: T,                        // 실제 데이터
    @SerializedName("msg") val msg: String                      // 클라이언트에서 메세지 출력 시 출력할 메세지
)