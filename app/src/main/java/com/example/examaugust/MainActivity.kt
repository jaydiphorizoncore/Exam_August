package com.example.examaugust

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examaugust.adapter.ProductAdapter
import com.example.examaugust.database.ProductDatabase
import com.example.examaugust.network.ApiInterface
import com.example.examaugust.network.ProductInterface
import com.example.examaugust.network.ProductRepository
import com.example.examaugust.network.ProductViewModel
import com.example.examaugust.network.ViewModelFactory
import com.example.examaugust.response.ListResponse
import com.example.examaugust.response.ProductData

class MainActivity : AppCompatActivity(), ProductInterface {
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var viewModel: ProductViewModel
    private lateinit var tvTotalItem: TextView
    private lateinit var progress: ProgressBar
    private var searchList = ArrayList<ProductData>()
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        prepairProductListRecyclerView()

        val api = ApiInterface()
        val productDao = ProductDatabase.getDatabase(this).getProductDao()
        val repository = ProductRepository(api, productDao)
        val factory = ViewModelFactory(this, repository)
        viewModel = ViewModelProvider(this, factory)[ProductViewModel::class.java]
        viewModel.productInterface = this
        viewModel.getData()

    }

    private fun prepairProductListRecyclerView() {
        productAdapter = ProductAdapter(this, ArrayList())

        listRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = productAdapter

        }
    }

    private fun initView() {
        listRecyclerView = findViewById(R.id.ProductListRecyclerView)
        tvTotalItem = findViewById(R.id.tv_total_item)
        searchView = findViewById(R.id.searchView)
        progress = findViewById(R.id.progressBar)
    }

    override fun onStarted() {
        Log.d("TAG", "onStarted")
    }

    override fun onSuccess(listResponse: ListResponse?) {

        if (listResponse != null) {
            progress.visibility = View.INVISIBLE
            tvTotalItem.text = "(" + listResponse.data.totalRecords.toString() + " Items)"
            productAdapter.setData(listResponse.data.productData)

            //Add Search Product Name
            searchList = listResponse.data.productData as ArrayList<ProductData>
            setSearchView(searchList)

        }
    }

    override fun onFailure(message: String) {
        Log.e("TAG", "onFailure")
    }

    private fun setSearchView(searchList: ArrayList<ProductData>) {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filterName = searchList.filter { name ->
                    name.productName.contains(newText!!, true)
                }
                productAdapter.setData(filterName)
                return true
            }
        })
    }
}