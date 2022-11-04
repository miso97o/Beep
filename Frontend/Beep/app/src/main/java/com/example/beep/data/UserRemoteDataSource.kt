package com.example.beep.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSource @Inject constructor(
    private val userApi: UserApi
) {

    fun signUpUser(
        userDto: UserDto
    ): Flow<BaseResponse<UserDto>> = flow {
        emit(userApi.signUpUser(userDto))
    }

    fun loginUser(
        map: HashMap<String, String>
    ): Flow<BaseResponse<TokenResponse>> = flow {
        emit(userApi.loginUser(map))
    }
}