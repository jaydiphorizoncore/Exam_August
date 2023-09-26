package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class X1(
    @SerializedName("attribute_id")
    val attributeId: Int,
    @SerializedName("attribute_name")
    val attributeName: String,
    @SerializedName("options")
    val options: Options
)