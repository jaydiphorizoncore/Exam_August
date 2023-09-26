package com.example.examaugust.network

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examaugust.ApiException
import com.example.examaugust.database.Product
import com.example.examaugust.database.ProductDatabase
import com.example.examaugust.request.ListRequest
import com.example.examaugust.request.ProductDetailsRequest
import com.example.examaugust.request.SearchArr
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(

    context: Context,
    private val productRepository: ProductRepository
) : ViewModel() {

    lateinit var productInterface: ProductInterface
    lateinit var productDetailsInterface: ProductDetailsInterface

    val allNotes: LiveData<List<Product>>
    private val repository: ProductRepository
    private val apiInterface = ApiInterface()

    init {
        val dao = ProductDatabase.getDatabase(context).getProductDao()
        repository = ProductRepository(apiInterface, dao)
        allNotes = repository.allNotes
    }

    fun getData() {
        productInterface.onStarted()
        CoroutineScope(Dispatchers.Main).launch {
            val token = AppConstants.TOKEN
            val headers = HashMap<String, String>()
            headers[AppConstants.KEY] = token
            val listRequest =
                ListRequest(
                    1, 4, "en",
                    "1", 1, "10", SearchArr(""),
                    "final_price", "asc"
                )
            try {
                val response = productRepository.getData(headers, listRequest)
                if (response != null) {
                    productInterface.onSuccess(response)
                }
            } catch (e: ApiException) {
                productInterface.onFailure(e.message!!)
            } catch (e: Exception) {
                Log.e(this::class.simpleName, e.message.toString())
                Log.e("Exception", "Exception: $e")
            }
        }
    }

    fun getDetailsData() {
        productDetailsInterface.onDetailsStarted()
        CoroutineScope(Dispatchers.Main).launch {
            val token = AppConstants.TOKEN
            val headers = HashMap<String, String>()
            headers[AppConstants.KEY] = token
            val productDetailsRequest =
                ProductDetailsRequest(1, 4, "en", "us-polo-assn-men-shirt-us-polo-assn")
            try {
                val response = productRepository.getDetailsData(headers, productDetailsRequest)
                if (response != null) {
                    productDetailsInterface.onDetailsSuccess(response)
                }
            } catch (e: ApiException) {
                productDetailsInterface.onDetailsFailure(e.message!!)
            } catch (e: Exception) {
                Log.e(this::class.simpleName, e.message.toString())
                Log.e("Exception", "DetailsException: $e")
            }
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(product)
        }
    }

}

