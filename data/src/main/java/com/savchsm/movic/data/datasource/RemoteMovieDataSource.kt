package com.savchsm.movic.data.datasource

import com.savchsm.movic.data.api.MoviesApi
import com.savchsm.movic.data.model.FilteredMoviesDTO
import com.savchsm.movic.data.model.NewArrivalsDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteMovieDataSource(private val api: MoviesApi) {

    fun fetchMovies(region: String): Flow<NewArrivalsDTO> = flow {
        val result = api.fetchNewMovies(region)
        emit(result)
    }
}