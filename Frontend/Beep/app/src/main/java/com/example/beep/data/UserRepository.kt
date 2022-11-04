package com.example.beep.data

import android.util.Log
import com.example.beep.util.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {

    // 일반 회원가입
    fun signUpUser(userDto: UserDto) = flow {
        emit(ResultType.Loading)
        userRemoteDataSource.signUpUser(userDto).collect {
            if (it.success) {
                emit(ResultType.Success(it))
            } else if (!it.success) {
                emit(ResultType.Fail(it))
            } else {
                emit(ResultType.Empty)
            }
        }
    }.catch { e ->
        emit(ResultType.Error(e))
    }

    private val TAG = "test5"

    // 일반 로그인
    fun loginUser(map: HashMap<String, String>): Flow<ResultType<BaseResponse<TokenResponse>>> =
        flow {
            emit(ResultType.Loading)
            userRemoteDataSource.loginUser(map).collect {
                Log.d(TAG, "loginUser: $it")
                if (it.success) {
                    emit(ResultType.Success(it))
                } else if (!it.success) {
                    emit(ResultType.Fail(it))
                } else {
                    emit(ResultType.Empty)
                }
            }

        }.catch { e ->
            emit(ResultType.Error(e))
            Log.d(TAG, "loginUser: $e")
        }
}