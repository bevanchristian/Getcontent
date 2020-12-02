package com.example.getcontent.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(tableName = "portofolio")
data class portofolio_entity(
    @PrimaryKey()
    @ColumnInfo(name = "id_portofolio")
    @NotNull
    var id_portofolio:String,
    @ColumnInfo(name = "id_vendor")
    @NotNull
    var id_vendor: String,
    @ColumnInfo(name = "nama_portofolio")
    @NotNull
    var nama_portofolio:String,
    @ColumnInfo(name = "foto_portofolio")
    @NotNull
    var foto_portofolio: Blob,
    @ColumnInfo(name = "deskripsi_portofolio")
    @NotNull
    var deskripsi_portofolio:String
)