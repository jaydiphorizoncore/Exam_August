package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class Options(
    @SerializedName("1")
    val x1: X1X,
    @SerializedName("2")
    val x2: X1X
)