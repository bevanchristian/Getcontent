package com.example.getcontent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDao {
    @get:Query("select nama_vendor from vendor")
    val all: List<String>

    @get:Query("SELECT gambar_promo FROM promo")
    val promo:List<String>

    @get:Query("select nama_vendor from vendor")
    val namavendor:List<String>
    @get:Query("select foto_profil_vendor from vendor")
    val fotovendor:List<String>

    @get:Query("select id_vendor from vendor")
    val idvendor:List<String>

    @get:Query("select nama_portofolio from portofolio")
    val namadesign:List<String>
    @get:Query("select foto_portofolio from portofolio")
    val fotodesign:List<String>
}