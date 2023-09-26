package com.example.examaugust

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.examaugust.database.Product
import com.example.examaugust.database.ProductDatabase
import com.example.examaugust.network.ApiInterface
import com.example.examaugust.network.ProductDetailsInterface
import com.example.examaugust.network.ProductRepository
import com.example.examaugust.network.ProductViewModel
import com.example.examaugust.network.ViewModelFactory
import com.example.examaugust.response.ProductDetailsResponse
import java.io.ByteArrayOutputStream

class DetailsActivity : AppCompatActivity(), ProductDetailsInterface {
    private lateinit var imgProductImage: ImageView
    private lateinit var tvProductLongDetails: TextView
    private lateinit var tvRatingDetails: TextView
    private lateinit var tvDetailReview: TextView
    private lateinit var tvPriceDetails: TextView
    private lateinit var tvMrpDetails: TextView
    private lateinit var tvYouSaveDetails: TextView
    private lateinit var btnSave: Button
    private lateinit var imgBack: ImageView
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initView()
        clickListener()

        val api = ApiInterface()
        val productDao = ProductDatabase.getDatabase(this).getProductDao()
        val repository = ProductRepository(api, productDao)
        val factory = ViewModelFactory(this, repository)
        viewModel = ViewModelProvider(this, factory)[ProductViewModel::class.java]
        viewModel.productDetailsInterface = this
        viewModel.getDetailsData()


        val img = intent.getStringExtra("IMG")
        Glide.with(this).load(img).into(imgProductImage)


        tvMrpDetails.paintFlags = tvMrpDetails.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

    }

    private fun initView() {
        imgProductImage = findViewById(R.id.img_product_details)
        tvProductLongDetails = findViewById(R.id.tv_product_long_details)
        tvRatingDetails = findViewById(R.id.tv_rating_details)
        tvDetailReview = findViewById(R.id.tv_details_review)
        tvPriceDetails = findViewById(R.id.tv_price_details)
        tvMrpDetails = findViewById(R.id.tv_mrp_details)
        tvYouSaveDetails = findViewById(R.id.tv_you_save_details)
        btnSave = findViewById(R.id.btn_save)
        imgBack = findViewById(R.id.img_back)
    }

    private fun clickListener() {
        imgBack.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        btnSave.setOnClickListener {

            val title = tvProductLongDetails.text.toString()
            val price = tvYouSaveDetails.text.toString()

            val img = imgProductImage.drawable
            val bitmap = (img as BitmapDrawable).bitmap
            val base64Image = encodeImageToBase64(bitmap)

            viewModel.addProduct(Product(title, price, base64Image))
            val i = Intent(this, MyCartActivity::class.java)
            startActivity(i)
        }
    }

    private fun encodeImageToBase64(bitmap: Bitmap?): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)

    }

    override fun onDetailsSuccess(productDetailsResponse: ProductDetailsResponse?) {
        if (productDetailsResponse != null) {
            for (data in productDetailsResponse.data.productData) {
                tvProductLongDetails.text = data.productName
                tvPriceDetails.text = data.finalPrice.toString()
                tvMrpDetails.text = data.retailPrice.toString()
            }

            tvRatingDetails.text =
                productDetailsResponse.data.customerProductReview.customerProductReviewRating

            for (data in productDetailsResponse.data.customerViewedProducts) {
                val retail = tvMrpDetails.text.toString()
                val final = tvPriceDetails.text.toString()

                val savePrice = retail.toInt() - final.toInt()
                val percentage = (savePrice.toFloat() / retail.toFloat() * 100).toInt()
                tvYouSaveDetails.text = savePrice.toString() + "( $percentage % )"
            }
            tvDetailReview.text =
                "( ${productDetailsResponse.data.customerProductReview.customerProductReviewCount} reviews)"
        }

    }

    override fun onDetailsStarted() {
        Log.d("TAG", "onDetailsStarted")
    }

    override fun onDetailsFailure(message: String) {
        Log.e("TAG", "onDetailsFailure")
    }
}