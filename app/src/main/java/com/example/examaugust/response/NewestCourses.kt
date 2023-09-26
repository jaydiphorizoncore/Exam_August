package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class NewestCourses(
    @SerializedName("image_icon_url")
    val imageIconUrl: String,
    @SerializedName("name")
    val name: String
)