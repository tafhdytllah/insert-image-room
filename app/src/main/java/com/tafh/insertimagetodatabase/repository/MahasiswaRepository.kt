package com.tafh.insertimagetodatabase.repository

import androidx.lifecycle.LiveData
import com.tafh.insertimagetodatabase.data.local.dao.MahasiswaDao
import com.tafh.insertimagetodatabase.model.Mahasiswa

class MahasiswaRepository(private val mahasiswaDao: MahasiswaDao) {

    val getAllMahasiswa: LiveData<List<Mahasiswa>> = mahasiswaDao.getAllMahasiswa()

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa) = mahasiswaDao.insertMahasiswa(mahasiswa)

}