package com.example.composepractice.network

import com.example.composepractice.models.LoginRequest
import com.example.composepractice.models.RecommendedConnectionResponse
import com.example.composepractice.models.SignUpResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("api/login_v3")
    suspend fun login(@Body loginRequest: LoginRequest): SignUpResponse

    @GET("api/user/recommendations")
    suspend fun getAllRecommendations(@Query("limit") limit: Int = 10): Response<RecommendedConnectionResponse>
}