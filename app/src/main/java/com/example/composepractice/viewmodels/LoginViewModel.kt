package com.example.composepractice.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepractice.models.LoginRequest
import com.example.composepractice.models.SignUpResponse
import com.example.composepractice.network.ApiResult
import com.example.composepractice.network.LocalDBManager
import com.example.composepractice.repositories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: LoginRepository,
    private val localDBManager: LocalDBManager
) : ViewModel() {

    var loginResponse: MutableStateFlow<ApiResult<SignUpResponse>> = MutableStateFlow(ApiResult.Loading)

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            repo.login(loginRequest).onStart {
                loginResponse.value = ApiResult.Loading
                Log.d("TAG", "loading")
            }.catch {
                Log.d("TAG", "exception: $it")
                loginResponse.value = ApiResult.Error(it.message)
            }.collect {
                localDBManager.setToken(it.customToken)
                loginResponse.value = ApiResult.Success(it)
                Log.d("TAG", "success: $it")
            }
        }
    }
}