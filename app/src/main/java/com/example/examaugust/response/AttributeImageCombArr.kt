package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class AttributeImageCombArr(
    @SerializedName("fancy_box_url")
    val fancyBoxUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String,
    @SerializedName("status")
    val status: Int
)