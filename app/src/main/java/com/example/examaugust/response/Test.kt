package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class Test(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("questions")
    val questions: String,
    @SerializedName("test_title")
    val testTitle: String
)