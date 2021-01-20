package com.tafh.insertimagetodatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tafh.insertimagetodatabase.databinding.ItemMahasiswaBinding
import com.tafh.insertimagetodatabase.model.Mahasiswa

class MahasiswaAdapter : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    private var list = listOf<Mahasiswa>()

    inner class MahasiswaViewHolder(private val binding: ItemMahasiswaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(mahasiswaList: Mahasiswa) {
            binding.apply {
                tvNama.text = mahasiswaList.nama
                tvNim.text = mahasiswaList.nim.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = ItemMahasiswaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(dataMahasiswa: List<Mahasiswa>) {
        this.list = dataMahasiswa
        notifyDataSetChanged()
    }
}