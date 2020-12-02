package com.example.getcontent.database

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









