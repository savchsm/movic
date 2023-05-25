package com.savchsm.movic.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.savchsm.movic.databinding.FragmentHomeBinding
import com.savchsm.movic.presentation.adapter.NewMoviesAdapter
import com.savchsm.movic.presentation.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by inject()
    private var newMoviesAdapter: NewMoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newMoviesAdapter = NewMoviesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        viewModel.fetchMovies()
    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner) {
            newMoviesAdapter?.update(it)
        }
    }

    private fun setupUI() = binding?.apply {
        carouselRecyclerView.adapter = newMoviesAdapter
    }
}