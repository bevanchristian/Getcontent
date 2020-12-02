package com.example.getcontent.database

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName="promo")
data class promoentity(
    @PrimaryKey()
    @ColumnInfo(name = "id_promo")
    @NotNull
    var id_promo: String,
    @ColumnInfo(name = "nama_promo")
    @NotNull
    var nama_promo:String,
    @ColumnInfo(name = "deskripsi_promo")
    @NotNull
    var deskripsi_promo:String,
    @ColumnInfo(name = "tanggal_promo")
    @NotNull
    var tanggal_promo:String,
    @ColumnInfo(name = "syarat_ketentuan")
    @NotNull
    var syarat_ketentuan:String,
    @ColumnInfo(name = "gambar_promo")
    @NotNull
    var gambar_promo: String,
    @ColumnInfo(name = "besar_potongan")
    @NotNull
    var besar_potongan:String
)