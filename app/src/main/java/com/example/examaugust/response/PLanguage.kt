package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class PLanguage(
    @SerializedName("id")
    val id: Int,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("long_description")
    val longDescription: String,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_slug")
    val productSlug: String,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("specification")
    val specification: String
)