package com.example.filmsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmsapp.MainActivity
import com.example.filmsapp.R
import com.example.filmsapp.data.entity.Films
import com.example.filmsapp.databinding.FragmentMainpageBinding
import com.example.filmsapp.ui.adapter.FilmsAdapter
import com.example.filmsapp.ui.viewmodel.MainpageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainpageFragment : Fragment() {

    private lateinit var binding: FragmentMainpageBinding
    private lateinit var viewModel : MainpageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mainpage, container, false)

        binding.mainpageToolbarHead = "Films"

        viewModel.filmsList.observe(viewLifecycleOwner){
            val filmsAdapter = FilmsAdapter(requireContext(), it)
            binding.filmsAdapter = filmsAdapter
        }


        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainpageViewModel by viewModels()
        viewModel = tempViewModel
    }
}
