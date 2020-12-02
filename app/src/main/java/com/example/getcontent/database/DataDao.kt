package com.example.getcontent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DataDao {
    @get:Query("Select * from vendor")
    val all: List<Any?>?

    @Insert
    fun insertAll(vararg dataEntities: promoentity?)
}