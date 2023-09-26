package com.example.examaugust.request


import com.google.gson.annotations.SerializedName

data class ListRequest(
    @SerializedName("device_type")
    val deviceType: Int,
    @SerializedName("entity_type_id")
    val entityTypeId: Int,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("page")
    val page: String,
    @SerializedName("pagination")
    val pagination: Int,
    @SerializedName("records_per_page")
    val recordsPerPage: String,
    @SerializedName("search_arr")
    val searchArr: SearchArr,
    @SerializedName("sort_by")
    val sortBy: String,
    @SerializedName("sort_order")
    val sortOrder: String
)