package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class AllCourses(
    @SerializedName("courses")
    val courses: List<Course>,
    @SerializedName("image_icon_url")
    val imageIconUrl: String,
    @SerializedName("name")
    val name: String
)