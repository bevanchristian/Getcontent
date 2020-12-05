package com.example.getcontent.database

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "paket_vendor")
data class paket_vendor_entity(
    @PrimaryKey
    @ColumnInfo(name = "id_paketvendor")
    val id_paketvendor:Int?,
    @ColumnInfo(name = "id_vendor")
    val id_vendor: Int?,
    @ColumnInfo(name = "nama_paket")
    val nama_paket:String?,
    @ColumnInfo(name = "deskripsi_paket")
    val deskripsi_paket:String?,
    @ColumnInfo(name = "harga")
    val harga:String?,
    @ColumnInfo(name = "foto_paket")
    val foto_paket: String?,
    @ColumnInfo(name = "id_promo")
    val id_promo:String?,
    @ColumnInfo(name = "harga_diskon")
    val harga_diskon:String?
)