package com.example.examaugust.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productTable")
class Product(

    @ColumnInfo(name = "name")
    val productName: String,

    @ColumnInfo(name = "price")
    val productPrice: String,

    @ColumnInfo(name = "image")
    val productImage: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
