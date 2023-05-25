package com.savchsm.movic.domain.repository

import com.savchsm.movic.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun fetchMovies(region: String): Flow<List<Movie>>
}