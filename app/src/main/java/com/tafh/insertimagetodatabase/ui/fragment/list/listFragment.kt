package com.tafh.insertimagetodatabase.ui.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tafh.insertimagetodatabase.adapter.MahasiswaAdapter
import com.tafh.insertimagetodatabase.databinding.FragmentListBinding
import com.tafh.insertimagetodatabase.model.Mahasiswa
import com.tafh.insertimagetodatabase.viewmodel.MahasiswaViewModel

class listFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MahasiswaViewModel by viewModels()
    private val mAdapter: MahasiswaAdapter by lazy { MahasiswaAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        //set recyclerview
        val recyclerView = binding.rvListMahasiswa
        recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

        // insert data
        insertData()

        // set data to adapter
        viewModel.getAllMahasiswa.observe(viewLifecycleOwner, Observer { mahasiswaList ->
            mAdapter.setData(mahasiswaList)
        })

        return view
    }

    private fun insertData() {
        val data = Mahasiswa("Taufik Hidayatullah", 41516010044)
        viewModel.insertMahasiswa(data)
    }

}