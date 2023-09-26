package com.example.examaugust.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examaugust.DetailsActivity
import com.example.examaugust.R
import com.example.examaugust.response.ProductData

class ProductAdapter(
    private val context: Context,
    private var listData: ArrayList<ProductData>,
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRating: TextView = itemView.findViewById(R.id.tv_rating)
        val tvDiscount: TextView = itemView.findViewById(R.id.tv_discount)
        val imgProduct: ImageView = itemView.findViewById(R.id.img_product)
        val tvProductName: TextView = itemView.findViewById(R.id.tv_product_name)
        val tvFinalPrice: TextView = itemView.findViewById(R.id.tv_final_prize)
        val tvRetailPrice: TextView = itemView.findViewById(R.id.tv_retail_prize)
        val itemConstraint: ConstraintLayout = itemView.findViewById(R.id.item_constraint_ll)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_furniture, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRating.text = listData[position].rating.toString()
        holder.tvDiscount.text = listData[position].discountValuePercentage.toString() + "% Off"

        Glide.with(context).load(listData[position].largeImageUrl).into(holder.imgProduct)
        holder.tvProductName.text = listData[position].productName
        holder.tvFinalPrice.text = listData[position].finalPrice.toString()
        holder.tvRetailPrice.text = listData[position].retailPrice.toString()
        holder.itemConstraint.setOnClickListener {
            val i = Intent(context, DetailsActivity::class.java)
            i.putExtra("IMG", listData[position].largeImageUrl)
            context.startActivity(i)
        }

    }

    fun setData(itemList: List<ProductData>) {
        this.listData = itemList as ArrayList<ProductData>
        notifyDataSetChanged()
    }


}