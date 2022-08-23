package com.example.composepractice.models

import com.google.gson.annotations.SerializedName

data class RecommendedConnectionResponse(
    val recommendations : List<RecommendedConnection>
)

data class RecommendedConnection(
    val id: Int,
    val name: String,
    val phone: String,
    val about: String?,
    val profileImageUrl: String?,
    val coverImageUrl: String?,
    val currentPosition: String?,
    val email: String,
    val headline: String?,
    @SerializedName("iAmLookingFor")
    val iAmLookingForIndustries: String,
    val isOnline: Boolean,
    val lastSeen: Any,
 //   val selfInterestedIndustries: IndustriesList?
)