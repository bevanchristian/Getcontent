package com.example.getcontent.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "paket_vendor_projek")
data class paket_vendor_projek_entity(
    @PrimaryKey()
    @ColumnInfo(name = "id_projek")
    var id_projek:Int?,
    @ColumnInfo(name = "id_paketvendor")
    var id_paketvendor: String?,
    @ColumnInfo(name = "foto")
    @NotNull
    var foto: String?,
    @ColumnInfo(name = "deskripsi")
    @NotNull
    var deskripsi:String?
)