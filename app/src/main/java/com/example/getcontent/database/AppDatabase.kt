package com.example.getcontent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(vendor_entity::class,promoentity::class,portofolio_entity::class,paket_vendor_entity::class,paket_vendor_projek_entity::class), version = 1, exportSchema = true)
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
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "getcontent2.db"
               ).allowMainThreadQueries().createFromAsset("getcontent2.db")
                .build()
        }
    }
}