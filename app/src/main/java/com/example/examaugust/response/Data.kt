package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("max_price")
    val maxPrice: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("product_data")
    val productData: List<ProductData>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_records")
    val totalRecords: Int
)