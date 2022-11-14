package com.example.beep.ui.message

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beep.data.dto.BaseResponse
import com.example.beep.data.dto.message.Message24Response
import com.example.beep.data.dto.message.MessageResponse
import com.example.beep.domain.Message24UseCase
import com.example.beep.domain.MessageUseCase
import com.example.beep.util.ResultType
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val message24UseCase: Message24UseCase
) :
    ViewModel() {

//    private val type = 1
//    val gson = Gson()
//    var message24UiState by mutableStateOf(Message24ScreenState())
//
//    fun getMessage24() {
//        viewModelScope.launch(Dispatchers.IO) {
//            if (message24UiState.receiveSendState == ReceiveSendState.Receive) {
//                message24UseCase.getReceive24()
//            } else {
//                message24UseCase.getSend24()
//            }
//        }
//    }
//
//    //message24를 보관 메시지로 저장
//    fun saveMsg24(messageId: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            message24UseCase.saveMsg(messageId).collectLatest {
//                if (it.code() == 200) {
//                    Log.d("SAVE Message24", it.body()!!)
//                } else {
//                    Log.d("SAVE Message24", "Fail!!")
//                }
//            }
//        }
//    }
//
//    fun deleteMsg24(messageId: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            message24UseCase.deleteMsg(messageId).collectLatest {
//                if (it.code() == 200) {
//                    Log.d("Delete Msg24", it.body()!!)
//                } else {
//                    Log.d("Delete Msg24", "Fail!!")
//                }
//            }
//        }
//    }
//
//    fun blockMsg24(messageId: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            message24UseCase.blockMsg(messageId).collectLatest {
//                if (it.code() == 200) {
//                    Log.d("Block Msg24", it.body()!!)
//                } else {
//                    Log.d("Block Msg24", "Fail!!")
//                }
//            }
//        }
//    }
}