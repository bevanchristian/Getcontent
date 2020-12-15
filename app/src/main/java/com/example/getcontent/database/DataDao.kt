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
    @get:Query("select deskripsi_vendor from vendor")
    val deskripsivendor:List<String>
    @get:Query("select id_vendor from vendor")
    val idvendor:List<Int>



    @get:Query("select nama_portofolio from portofolio")
    val namadesign:List<String>
    @get:Query("select foto_portofolio from portofolio")
    val fotodesign:List<String>



    @get:Query("select id_vendor from portofolio")
    val idvendordesign:List<Int>
    @get:Query("select id_paketvendor from portofolio")
    val idpaketvendordesign:List<Int>
    @Query("select nama_vendor from vendor where id_vendor=:nama")
    fun namavendordesign(nama:String):String


    //project service

    @Query(" select nama_portofolio from portofolio where id_paketvendor=:idpaket and id_vendor=:idvendor")
    fun namaprojectservice(idvendor:String,idpaket:String):List<String>
    @Query(" select foto_portofolio from portofolio where id_paketvendor=:idpaket and id_vendor=:idvendor")
    fun fotoprojectservice(idvendor:String,idpaket:String):List<String>


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
    @Query("select id_paketvendor from paket_vendor where id_vendor=:kode")
    fun idpaketdetailvendor(kode:String):List<Int>


    //portofoliodetailvendor

    @Query("select foto_portofolio from portofolio where id_vendor=:kode")
    fun portofoliodetailvendor(kode:String):List<String>

    //untuk detail service

    @Query("select foto_paket from paket_vendor where id_paketvendor=:kode")
    fun fotodetailservice(kode:String):String
    @Query("select nama_paket from paket_vendor where id_paketvendor=:kode")
    fun namadetailservice(kode:String):String
    @Query("select harga from paket_vendor where id_paketvendor=:kode")
    fun hargadetailservice(kode:String):String
    @Query("select deskripsi_paket from paket_vendor where id_paketvendor=:kode")
    fun deskripsidetailservice(kode:String):String





}