package com.example.composepractice.models

import com.google.gson.annotations.SerializedName

data class IndustriesListItem(
    var itemSelected: Boolean = false,
    val id: Int,
    @SerializedName("pngImageUrl")
    val imageUrl: String?,
    val name: String? = null,
    val normalImageId: Int? = null,
    val selectedImageUrl: String? = null,
    val category: String? = null,
    val selectedImageId: Int? = null,
    var isSelected: Boolean = false,
    var isChecked: Boolean = false
)

data class PngResponse(
    val pngInfo: PngResponseItem
)

data class PngResponseItem(
    val pngUrl: String?,
    val pngId: Int
)