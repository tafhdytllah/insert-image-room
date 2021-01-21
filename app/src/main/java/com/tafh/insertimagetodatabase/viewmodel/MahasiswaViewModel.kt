package com.tafh.insertimagetodatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tafh.insertimagetodatabase.data.local.database.MahasiswaDatabase
import com.tafh.insertimagetodatabase.data.local.entity.Mahasiswa
import com.tafh.insertimagetodatabase.repository.MahasiswaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MahasiswaViewModel(application: Application) : AndroidViewModel(application) {

    private val mahasiswaDao = MahasiswaDatabase.getDatabase(application).mahasiswaDao()
    private val repository = MahasiswaRepository(mahasiswaDao)

    val getAllMahasiswa: LiveData<List<Mahasiswa>> = repository.getAllMahasiswa

    fun insertMahasiswa(mahasiswa: Mahasiswa) = viewModelScope.launch(Dispatchers.IO) { repository.insertMahasiswa(mahasiswa) }

}