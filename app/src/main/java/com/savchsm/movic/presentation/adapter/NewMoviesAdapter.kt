package com.savchsm.movic.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.savchsm.movic.databinding.ItemNewMovieBinding
import com.savchsm.movic.domain.models.Movie
import kotlin.coroutines.coroutineContext

class NewMoviesAdapter : RecyclerView.Adapter<NewMoviesAdapter.NewMovieVH>() {

    private val movies: MutableList<Movie> = mutableListOf()

    fun update(newData: List<Movie>) {
        movies.clear()
        movies.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieVH {
        val binding =
            ItemNewMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewMovieVH(binding)
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: NewMovieVH, position: Int) {
        val movie = movies[position]
        holder.binding.carouselImageView.apply {
            Glide.with(this)
                .load(movie.url)
                .into(this)
        }
    }

    inner class NewMovieVH(val binding: ItemNewMovieBinding) : RecyclerView.ViewHolder(binding.root)
}