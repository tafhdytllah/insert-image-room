package com.tafh.insertimagetodatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa_table")
data class Mahasiswa(
    val nama: String,
    val nim: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}