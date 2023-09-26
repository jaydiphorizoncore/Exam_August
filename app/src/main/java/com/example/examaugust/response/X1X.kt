package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class X1X(
    @SerializedName("attribute_option_id")
    val attributeOptionId: Int,
    @SerializedName("attribute_option_value")
    val attributeOptionValue: String
)