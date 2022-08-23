package com.example.composepractice.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    @Inject
    lateinit var localDBManager: LocalDBManager

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val token   = localDBManager.getToken()
        Log.d("TAG", "intercept: $token")
//        request.newBuilder()
//            .header("Authorization", "Bearer Token")
//            .header("x-session-token", appSessionToken!!)
//            .method(request.method, request.body)

        request.newBuilder().header("Authorization","Bearer $token")

        return chain.proceed(request)
    }
}