package com.example.composepractice.repositories

import com.example.composepractice.models.LoginRequest
import com.example.composepractice.models.SignUpResponse
import com.example.composepractice.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class LoginRepository @Inject constructor(private val api: ApiInterface) {

    fun login(loginRequest: LoginRequest): Flow<SignUpResponse> = flow {
        emit(api.login(loginRequest))
    }.flowOn(Dispatchers.IO)

}