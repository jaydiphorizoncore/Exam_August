package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class CustomerProductReview(
    @SerializedName("customer_product_review_count")
    val customerProductReviewCount: Int,
    @SerializedName("customer_product_review_rating")
    val customerProductReviewRating: String,
    @SerializedName("data")
    val `data`: List<Any>
)