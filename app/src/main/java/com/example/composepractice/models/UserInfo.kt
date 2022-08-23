package com.example.composepractice.models

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class UserInfo(
    val dateOfBirth: Date?,
    val email: String?,
    var emailVerifiedAt: Date?,
    val gender: GenderType?,
    val id: Int,
    val isSuspended: Boolean,
    val name: String,
    val phone: String?,
    var phoneVerifiedAt: Date?,
    val rating: Int?,
    var selfInterestedIndustries: ArrayList<IndustriesListItem>?,
    val settings: Settings?,
    val inviteCode : String?,
    val about: String?,
    val profileImageId: Int?,
    val headline: String?,
    val currentPosition: String?,
    val lookingFor: String?,
    @SerializedName("skipPhone")
    val canSkipPhone: Boolean = true,
    var skipByUserAtFrontend: Boolean = false,
    val showSkipPhonePopup : Boolean,
    val showSkipPhonePopupAfterTime: Date?,
    var openPhoneVerificationScreen : Boolean = true
){

}

data class Settings(
    val blockedContacts: List<BlockedContacts>,
    val lastSeenVisibleTo: String,
    val newConnectNotifications: Boolean,
    val newMessageNotifications: Boolean,
    val notificationsTone: String,
    val profilePhotoVisibleTo: String,
    val vibrate: Boolean,
    val totalBlockedContacts: Int?
)

data class BlockedContacts(
    val id: Int,
    val name: String,
    val imageId: Int?,
    val imageUrl: String
)

enum class GenderType{
    male, female, other,non_binary, none
}