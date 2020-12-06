package com.example.getcontent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDao {
    @get:Query("select nama_vendor from vendor")
    val all: List<String>

    @get:Query("SELECT gambar_promo FROM promo")
    val promo:String
}