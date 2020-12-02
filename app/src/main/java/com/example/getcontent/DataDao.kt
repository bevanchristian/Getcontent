package com.example.getcontent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDao {
    @get:Query("SELECT * FROM DataEntity")
    val all: List<Any?>?

    @Insert
    fun insertAll(vararg dataEntities: DataEntity?)
}