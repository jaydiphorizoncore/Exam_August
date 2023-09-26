package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class ProductSupplier(
    @SerializedName("added_by_id")
    val addedById: Int,
    @SerializedName("added_date")
    val addedDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("supplier_id")
    val supplierId: Int,
    @SerializedName("supplier_name")
    val supplierName: String
)