package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("attribute_image_comb_arr")
    val attributeImageCombArr: List<AttributeImageCombArr>,
    @SerializedName("can_store_user_add_review")
    val canStoreUserAddReview: String,
    @SerializedName("customer_product_review")
    val customerProductReview: CustomerProductReview,
    @SerializedName("customer_viewed_products")
    val customerViewedProducts: List<CustomerViewedProduct>,
    @SerializedName("options")
    val options: List<Int>,
    @SerializedName("pack_details")
    val packDetails: List<PackDetail>,
    @SerializedName("product_associate_attribute")
    val productAssociateAttribute: ProductAssociateAttribute,
    @SerializedName("product_data")
    val productData: List<ProductDataX>,
    @SerializedName("product_other_info")
    val productOtherInfo: List<Any>,
    @SerializedName("similar_product")
    val similarProduct: List<SimilarProduct>
)