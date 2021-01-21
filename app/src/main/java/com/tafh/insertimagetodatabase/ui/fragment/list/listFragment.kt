package com.tafh.insertimagetodatabase.ui.fragment.list

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.tafh.insertimagetodatabase.adapter.MahasiswaAdapter
import com.tafh.insertimagetodatabase.databinding.FragmentListBinding
import com.tafh.insertimagetodatabase.model.Mahasiswa
import com.tafh.insertimagetodatabase.viewmodel.MahasiswaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.log

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

        binding.rvListMahasiswa.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }

        lifecycleScope.launch {
            val data  = Mahasiswa("Taufik", 41516010044, getBitmap())
            viewModel.insertMahasiswa(data)
        }

        viewModel.getAllMahasiswa.observe(viewLifecycleOwner, Observer {
            mAdapter.setData(it)
        })


        return view
    }


    private suspend fun getBitmap(): Bitmap {
        val imageLoader = ImageLoader(requireContext())
        val request = ImageRequest.Builder(requireContext())
            .data("https://images.pexels.com/photos/4769486/pexels-photo-4769486.jpeg?cs=srgb&dl=pexels-cottonbro-4769486.jpg&fm=jpg")
            .size(120,120)
            .build()

        val drawable = imageLoader.execute(request).drawable

        return (drawable as BitmapDrawable).bitmap //return = android.graphics.Bitmap@afffb69

    }

}