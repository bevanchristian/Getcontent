package com.example.getcontent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDao {
    @get:Query("Select nama_portofolio from portofolio")
    val all: List<String?>
}