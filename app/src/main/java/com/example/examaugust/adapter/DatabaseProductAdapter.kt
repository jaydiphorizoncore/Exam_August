package com.example.examaugust.adapter

import android.app.Activity
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examaugust.R
import com.example.examaugust.database.Product

class DatabaseProductAdapter(
    private val context: Context,
    private val productClickDeleteInterface: NoteClickDeleteInterface
) :
    RecyclerView.Adapter<DatabaseProductAdapter.ViewHolder>() {

    private val allProduct = ArrayList<Product>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvProductName: TextView = itemView.findViewById(R.id.tv_product_details_my_cart)

        val imgProduct: ImageView = itemView.findViewById(R.id.img_product_my_cart)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tv_sar_my_cart)
        val imgDelete: ImageView = itemView.findViewById(R.id.btn_product_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_my_cart, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return allProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvProductName.text = allProduct[position].productName

        val img = allProduct[position].productImage
        val decodedBytes = Base64.decode(img, Base64.DEFAULT)
        val decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)

        Glide.with(context).load(decodedBitmap).into(holder.imgProduct)
      //  holder.imgProduct.setImageBitmap(decodedBitmap)
        holder.tvProductPrice.text = allProduct[position].productPrice
        holder.imgDelete.setOnClickListener {
            productClickDeleteInterface.onDeleteIconClick(allProduct[position])
        }
    }

    fun updateList(newList: List<Product>) {
        allProduct.clear()
        allProduct.addAll(newList)
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface {
    fun onDeleteIconClick(product: Product)
}
