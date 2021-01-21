package com.tafh.insertimagetodatabase.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa_table")
data class Mahasiswa(
    val nama: String,
    val nim: Long,
    val profileFoto: Bitmap
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}