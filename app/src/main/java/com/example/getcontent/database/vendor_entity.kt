package com.example.getcontent.database

import android.media.Image
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "vendor")
data class vendor_entity(
    @PrimaryKey() @ColumnInfo(name = "id_vendor") var id_vendor:Int?,
    @ColumnInfo(name = "nama_vendor")
    val nama_vendor:String?,
    @ColumnInfo(name = "deskripsi_vendor")
    val deskripsi_vendor:String?,
    @ColumnInfo(name = "foto_profil_vendor")
    val foto_profil_vendor: String?,
    @ColumnInfo(name = "bintang")
    val bintang:String?,
    @ColumnInfo(name = "no_telp")
    val no_telp:String?,
    @ColumnInfo(name = "fotobanner")
    val fotobaner: String?

)