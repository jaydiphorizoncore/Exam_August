package com.example.examaugust.network

import com.example.examaugust.response.ListResponse
import com.example.examaugust.response.ProductData
import com.example.examaugust.response.ProductDetailsResponse

interface ProductInterface {

    fun onStarted()
    fun onSuccess(listResponse: ListResponse?)
    fun onFailure(message: String)

}