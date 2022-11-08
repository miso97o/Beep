package com.example.beep.data.repository

import com.example.beep.data.datasource.AddressDataSource
import com.example.beep.data.dto.mainpage.AddressResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddressRepository @Inject constructor(private val addressDataSource: AddressDataSource) {
    fun getUserAddress(): Flow<List<AddressResponse>> =
        flow { addressDataSource.getUserAddress().collect { emit(it)} }
}