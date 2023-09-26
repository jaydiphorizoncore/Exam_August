package com.example.examaugust.network

import androidx.room.Dao
import com.example.examaugust.request.ListRequest
import com.example.examaugust.request.ProductDetailsRequest
import com.example.examaugust.response.ListResponse
import com.example.examaugust.response.ProductDetailsResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

@Dao
interface ApiInterface {

    @POST("get-product-list")
    suspend fun getProduct(
        @HeaderMap headerMap: Map<String, String>,
        @Body listRequest: ListRequest
    ): Response<ListResponse>

    @POST("get-product-details")
    suspend fun getDetailsProduct(
        @HeaderMap headerMap: Map<String, String>,
        @Body productDetailsRequest: ProductDetailsRequest
    ): Response<ProductDetailsResponse>


    companion object {
        operator fun invoke(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client: OkHttpClient =
                OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
                    val newRequest: Request = chain.request().newBuilder().addHeader(
                        "Authorization", "Bearer " + AppConstants.AUTHORIZATION_BEARER_TOKEN
                    ).build()
                    chain.proceed(newRequest)
                }).build()
            return Retrofit.Builder().baseUrl("http://192.168.32.160/tmween/panel/public/api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiInterface::class.java)
        }
    }
}