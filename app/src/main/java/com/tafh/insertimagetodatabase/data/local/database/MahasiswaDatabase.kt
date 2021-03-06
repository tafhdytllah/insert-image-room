package com.tafh.insertimagetodatabase.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tafh.insertimagetodatabase.data.local.dao.MahasiswaDao
import com.tafh.insertimagetodatabase.data.local.entity.Mahasiswa
import com.tafh.insertimagetodatabase.data.local.Converter

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class MahasiswaDatabase : RoomDatabase(){

    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile
        private var INSTANCE: MahasiswaDatabase? = null

        fun getDatabase(context: Context): MahasiswaDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MahasiswaDatabase::class.java,
                "mahasiswa-db"
            ).build()

    }
}