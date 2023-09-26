package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class ProductGallery(
    @SerializedName("fancy_box_url")
    val fancyBoxUrl: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String,
    @SerializedName("order_by")
    val orderBy: Int,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("small_image_url")
    val smallImageUrl: String
)