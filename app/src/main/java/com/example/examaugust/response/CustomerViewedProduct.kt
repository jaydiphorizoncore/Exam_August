package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class CustomerViewedProduct(
    @SerializedName("attribute_set_id")
    val attributeSetId: Int,
    @SerializedName("autogenerate_seo")
    val autogenerateSeo: Int,
    @SerializedName("brand_id")
    val brandId: Int,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("customer_id")
    val customerId: Int,
    @SerializedName("expirable")
    val expirable: Int,
    @SerializedName("final_price")
    val finalPrice: Int,
    @SerializedName("freezable")
    val freezable: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("in_stock")
    val inStock: Int,
    @SerializedName("is_best_sellers")
    val isBestSellers: Int,
    @SerializedName("is_combination_available")
    val isCombinationAvailable: Int,
    @SerializedName("is_system_product")
    val isSystemProduct: Int,
    @SerializedName("is_top_selection")
    val isTopSelection: Int,
    @SerializedName("long_description")
    val longDescription: String,
    @SerializedName("manufacturer_number")
    val manufacturerNumber: String,
    @SerializedName("max_auto_order_quantity")
    val maxAutoOrderQuantity: Int,
    @SerializedName("meta_description")
    val metaDescription: String,
    @SerializedName("meta_keywords")
    val metaKeywords: String,
    @SerializedName("meta_title")
    val metaTitle: String,
    @SerializedName("pack_product_dimensions_unit_id")
    val packProductDimensionsUnitId: Int,
    @SerializedName("pack_product_height")
    val packProductHeight: String,
    @SerializedName("pack_product_length")
    val packProductLength: String,
    @SerializedName("pack_product_weight")
    val packProductWeight: Int,
    @SerializedName("pack_product_weight_unit_id")
    val packProductWeightUnitId: Int,
    @SerializedName("pack_product_width")
    val packProductWidth: String,
    @SerializedName("product_category_id")
    val productCategoryId: Int,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("product_in_one_pack")
    val productInOnePack: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_slug")
    val productSlug: String,
    @SerializedName("recently_id")
    val recentlyId: Int,
    @SerializedName("retail_price")
    val retailPrice: Int,
    @SerializedName("reviews_avg")
    val reviewsAvg: Int,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("show_in_web")
    val showInWeb: Int,
    @SerializedName("single_product_dimensions_unit_id")
    val singleProductDimensionsUnitId: Int,
    @SerializedName("single_product_height")
    val singleProductHeight: String,
    @SerializedName("single_product_length")
    val singleProductLength: String,
    @SerializedName("single_product_weight")
    val singleProductWeight: Int,
    @SerializedName("single_product_width")
    val singleProductWidth: String,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("special_transport_id")
    val specialTransportId: Any,
    @SerializedName("specification")
    val specification: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("storage_conditions")
    val storageConditions: String,
    @SerializedName("tax_class")
    val taxClass: Int,
    @SerializedName("upc")
    val upc: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("vat_id")
    val vatId: Int,
    @SerializedName("vehicle_type_code")
    val vehicleTypeCode: String,
    @SerializedName("weight_unit_id")
    val weightUnitId: Int
)