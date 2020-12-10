package com.example.getcontent.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File


@Database(entities = arrayOf(vendor_entity::class,promoentity::class,portofolio_entity::class,paket_vendor_entity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE =
                    buildDatabase(
                        context
                    )
            }
            return INSTANCE
        }


        private fun buildDatabase(context: Context): AppDatabase {
            Log.d("sql","sudah dibuat")
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "getcontent5.db"
               ).createFromAsset("databases/sqlite (17) (2) (1).db").allowMainThreadQueries()
                .build()

        }
    }
}