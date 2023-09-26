package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class Toppers(
    @SerializedName("topers_data")
    val topersData: List<TopersData>,
    @SerializedName("topers_label")
    val topersLabel: String
)