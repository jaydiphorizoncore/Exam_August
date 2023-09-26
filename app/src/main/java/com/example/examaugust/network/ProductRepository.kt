package com.example.examaugust.network

import androidx.lifecycle.LiveData
import com.example.examaugust.SafeApiRequest
import com.example.examaugust.database.Product
import com.example.examaugust.database.ProductDao
import com.example.examaugust.request.ListRequest
import com.example.examaugust.request.ProductDetailsRequest
import com.example.examaugust.response.ListResponse
import com.example.examaugust.response.ProductDetailsResponse

class ProductRepository(
    private val apiInterface: ApiInterface,
    private val productDao: ProductDao
) : SafeApiRequest() {
    val allNotes: LiveData<List<Product>> = productDao.getAllProduct()

    suspend fun getData(headerMap: Map<String, String>, listRequest: ListRequest): ListResponse? {
        return apiRequest { apiInterface.getProduct(headerMap, listRequest) }
    }

    suspend fun getDetailsData(
        headerMap: Map<String, String>,
        productDetailsRequest: ProductDetailsRequest
    ): ProductDetailsResponse? {
        return apiRequest { apiInterface.getDetailsProduct(headerMap, productDetailsRequest) }
    }

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    suspend fun delete(product: Product) {
        productDao.delete(product)
    }

}