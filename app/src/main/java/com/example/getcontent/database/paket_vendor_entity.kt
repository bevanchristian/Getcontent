package com.example.getcontent.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "paket_vendor")
data class paket_vendor_entity(
    @PrimaryKey
    @ColumnInfo(name = "id_paketvendor")
    @NotNull
    var id_paketvendor:String,
    @ColumnInfo(name = "id_vendor")
    @NotNull
    var id_vendor: String,
    @ColumnInfo(name = "nama_paket")
    @NotNull
    var nama_paket:String,
    @ColumnInfo(name = "deskripsi_paket")
    @NotNull
    var deskripsi_paket:String,
    @ColumnInfo(name = "harga")
    @NotNull
    var harga:String,
    @ColumnInfo(name = "foto_paket")
    @NotNull
    var foto_paket: Blob,
    @ColumnInfo(name = "id_promo")
    @NotNull
    var id_promo:String,
    @ColumnInfo(name = "harga_diskon")
    @NotNull
    var harga_diskon:String
)