package com.tafh.insertimagetodatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.tafh.insertimagetodatabase.R
import com.tafh.insertimagetodatabase.databinding.ItemMahasiswaBinding
import com.tafh.insertimagetodatabase.model.Mahasiswa

class MahasiswaAdapter : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    private var list = emptyList<Mahasiswa>()

    inner class MahasiswaViewHolder(private val binding: ItemMahasiswaBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(mahasiswa: Mahasiswa) {
            binding.apply {
                tvNama.text = mahasiswa.nama
                tvNim.text = mahasiswa.nim.toString()
                ivFoto.load(mahasiswa.profileFoto) {
                    crossfade(true)
                    crossfade(1)
                    placeholder(R.drawable.ic_baseline_image_120)
                    transformations(CircleCropTransformation())
                }
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