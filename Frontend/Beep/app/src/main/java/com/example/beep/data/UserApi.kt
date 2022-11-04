package com.example.beep.data

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface UserApi {

    @POST("user/signup")
    suspend fun signUpUser(
        @Body userDto: UserDto
    ):BaseResponse<UserDto>

    @POST("user/login")
    suspend fun loginUser(
        @Body map: HashMap<String, String>
    ):BaseResponse<TokenResponse>



}