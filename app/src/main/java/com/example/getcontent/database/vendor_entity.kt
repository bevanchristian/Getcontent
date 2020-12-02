package com.example.getcontent.database

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "vendor")
data class vendor_entity(
    @PrimaryKey()
    @ColumnInfo(name = "id_vendor")
    @NotNull
    val id_vendor:String,
    @ColumnInfo(name = "nama_vendor")
    @NotNull
    val nama_vendor:String,
    @ColumnInfo(name = "deskripsi_vendor")
    @NotNull
    val deskripsi_vendor:String,
    @ColumnInfo(name = "foto_profil_vendor")
    @NotNull
    val foto_profil_vendor: String,
    @ColumnInfo(name = "bintang")
    @NotNull
    val bintang:String,
    @ColumnInfo(name = "no_telp")
    @NotNull
    val no_telp:String,
    @ColumnInfo(name = "fotobaner")
    @NotNull
    val fotobaner: String

)