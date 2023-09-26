package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class ProductPack(
    @SerializedName("dimension_unit_id")
    val dimensionUnitId: Int,
    @SerializedName("height")
    val height: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("length")
    val length: String,
    @SerializedName("market_price")
    val marketPrice: Int,
    @SerializedName("pack_size")
    val packSize: Int,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("weight_unit_id")
    val weightUnitId: Int,
    @SerializedName("width")
    val width: String
)