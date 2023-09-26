package com.example.examaugust.request


import com.google.gson.annotations.SerializedName

data class SearchArr(
    @SerializedName("keyword")
    val keyword: String
)