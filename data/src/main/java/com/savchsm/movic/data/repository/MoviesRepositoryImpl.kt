package com.savchsm.movic.data.repository

import com.savchsm.movic.data.datasource.RemoteMovieDataSource
import com.savchsm.movic.data.model.toMovie
import com.savchsm.movic.domain.models.Movie
import com.savchsm.movic.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MoviesRepositoryImpl(
    private val apiSource: RemoteMovieDataSource
) : MoviesRepository {

    override fun fetchMovies(region: String): Flow<List<Movie>> =
        apiSource.fetchMovies(region).map { dto -> dto.results?.map { it.toMovie() } ?: listOf() }
}