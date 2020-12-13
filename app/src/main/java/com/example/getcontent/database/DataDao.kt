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
    val idvendor:List<Int>



    @get:Query("select nama_portofolio from portofolio")
    val namadesign:List<String>
    @get:Query("select foto_portofolio from portofolio")
    val fotodesign:List<String>

    //pagedetailvendor
    @Query("select foto_profil_vendor from vendor where id_vendor=:kode")
    fun fotodetailvendor(kode:String):String

    @Query("select nama_vendor from vendor where id_vendor=:kode")
    fun namadetailvendor(kode:String):String

    @Query("select deskripsi_vendor from vendor where id_vendor=:kode")
    fun deskripsidetailvendor(kode:String):String

    @Query("select no_telp from vendor where id_vendor=:kode")
    fun nomordetailvendor(kode:String):String

    @Query("select fotobanner from vendor where id_vendor=:kode")
    fun bannerdetailvendor(kode:String):String

    //paketdetailvendor
    @Query("select foto_paket from paket_vendor where id_vendor=:kode")
    fun paketdetailvendor(kode:String):List<String>




}