package com.example.examaugust.network

import com.example.examaugust.response.ProductDetailsResponse

interface ProductDetailsInterface {
    fun onDetailsSuccess(ProductDetailsResponse: ProductDetailsResponse?)
    fun onDetailsStarted()
    fun onDetailsFailure(message: String)
}