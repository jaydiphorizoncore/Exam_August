package com.example.examaugust.request


import com.google.gson.annotations.SerializedName

data class ProductDetailsRequest(
    @SerializedName("device_type")
    val deviceType: Int,
    @SerializedName("entity_type_id")
    val entityTypeId: Int,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("slug")
    val slug: String
)