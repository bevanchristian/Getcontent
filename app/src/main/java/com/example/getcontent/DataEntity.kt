package com.example.getcontent

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "vendor")
data class vendor(
    @PrimaryKey()
    @ColumnInfo(name = "id_vendor")
    @NotNull
    var id_vendor:String,
    @ColumnInfo(name = "nama_vendor")
    @NotNull
    var nama_vendor:String,
    @ColumnInfo(name = "deskripsi_vendor")
    @NotNull
    var deskripsi_vendor:String,
    @ColumnInfo(name = "foto_profil_vendor")
    @NotNull
    var foto_profil_vendor:Blob,
    @ColumnInfo(name = "bintang")
    @NotNull
    var bintang:String,
    @ColumnInfo(name = "no_telp")
    @NotNull
    var no_telp:String,
    @ColumnInfo(name = "fotobaner")
    @NotNull
    var fotobaner:Blob

)

@Entity(tableName = "portofolio")
data class portofolio(
    @PrimaryKey()
    var id_portofolio:String,
    var id_vendor: String,
    var nama_portofolio:String,
    var foto_portofolio:Blob,
    var deskripsi_portofolio:String
)


@Entity(tableName = "paket_vendor")
data class paket_vendor(
    @PrimaryKey
    var id_paketvendor:String,
    var id_vendor: String,
    var nama_paket:String,
    var deskripsi_paket:String,
    var harga:String,
    var foto_paket:Blob,
    var id_promo:String,
    var harga_diskon:String
)

@Entity(tableName = "paket_vendor_projek")
data class paket_vendor_projek(
    var id_projek:String,
    var id_paketvendor: String,
    var foto:Blob,
    var deskripsi:String
)
