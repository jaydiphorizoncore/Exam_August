package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("data")
    val `data`: DataXX,
    @SerializedName("message")
    val message: String,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("status_message")
    val statusMessage: String
)