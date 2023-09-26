package com.example.examaugust

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.examaugust.adapter.DatabaseProductAdapter
import com.example.examaugust.adapter.NoteClickDeleteInterface
import com.example.examaugust.database.Product
import com.example.examaugust.database.ProductDatabase
import com.example.examaugust.network.ApiInterface
import com.example.examaugust.network.ProductRepository
import com.example.examaugust.network.ProductViewModel
import com.example.examaugust.network.ViewModelFactory

class MyCartActivity : AppCompatActivity(), NoteClickDeleteInterface {
    private lateinit var myCartRecyclerView: RecyclerView
    private lateinit var imgBackMyCart: ImageView
    private lateinit var myCartAdapter: DatabaseProductAdapter
    private lateinit var viewModal: ProductViewModel
    private lateinit var tvTotalItemCountMyCart: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        val api = ApiInterface()
        val productDao = ProductDatabase.getDatabase(this).getProductDao()
        val repository = ProductRepository(api, productDao)
        val factory = ViewModelFactory(
            this, repository
        )
        viewModal = ViewModelProvider(this, factory)[ProductViewModel::class.java]

        tvTotalItemCountMyCart = findViewById(R.id.tv_total_item_count_my_cart)
        clickListener()

        myCartRecyclerView = findViewById(R.id.my_cart_recyclerview)
        myCartAdapter = DatabaseProductAdapter(this, this)
        myCartRecyclerView.adapter = myCartAdapter


        viewModal.allNotes.observe(this, Observer { list ->
            list?.let {
                myCartAdapter.updateList(it)
                tvTotalItemCountMyCart.text = " ( " + it.size.toString() + " ) "
            }
        })
    }

    private fun clickListener() {
        imgBackMyCart = findViewById(R.id.img_back_my_cart)
        imgBackMyCart.setOnClickListener {
            val i = Intent(this, DetailsActivity::class.java)
            startActivity(i)
        }
    }

    override fun onDeleteIconClick(product: Product) {
        viewModal.deleteProduct(product)
        // Toast.makeText(this, "Product Deleted", Toast.LENGTH_LONG).show()
        toast("Product Deleted")
    }
}