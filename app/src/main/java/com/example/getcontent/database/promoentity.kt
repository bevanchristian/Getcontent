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
    var id_promo: Int?,
    @ColumnInfo(name = "nama_promo")
    var nama_promo:String?,
    @ColumnInfo(name = "deskripsi_promo")
    var deskripsi_promo:String?,
    @ColumnInfo(name = "tanggal_promo")
    var tanggal_promo:String?,
    @ColumnInfo(name = "syarat_ketentuan")
    var syarat_ketentuan:String?,
    @ColumnInfo(name = "gambar_promo")
    var gambar_promo: String?,
    @ColumnInfo(name = "besar_potongan")
    var besar_potongan:String?
)