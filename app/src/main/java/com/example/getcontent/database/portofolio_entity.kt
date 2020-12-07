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
    var id_portofolio:Int?,
    @ColumnInfo(name = "id_vendor")
    var id_vendor: Int?,
    @ColumnInfo(name = "nama_portofolio")
    var nama_portofolio:String?,
    @ColumnInfo(name = "foto_portofolio")
    var foto_portofolio: String?,
    @ColumnInfo(name = "deskripsi_portofolio")
    var deskripsi_portofolio:String?,

    /*id_paket harus  id paket vendor ben ketika dipencet tau ke service apa*/
    @ColumnInfo(name = "id_paketvendor")
    var id_paketvendor:Int?
)