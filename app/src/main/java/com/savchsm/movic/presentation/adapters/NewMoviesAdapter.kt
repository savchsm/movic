package com.savchsm.movic.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.savchsm.movic.databinding.ItemNewMovieBinding

class NewMoviesAdapter : RecyclerView.Adapter<NewMoviesAdapter.NewMovieVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieVH {
        val binding = ItemNewMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewMovieVH(binding)
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: NewMovieVH, position: Int) = with(holder.binding) {}

    inner class NewMovieVH(val binding: ItemNewMovieBinding) : RecyclerView.ViewHolder(binding.root)
}