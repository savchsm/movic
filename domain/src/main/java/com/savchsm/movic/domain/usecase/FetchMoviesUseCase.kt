package com.savchsm.movic.domain.usecase

import com.savchsm.movic.domain.models.Movie
import com.savchsm.movic.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class FetchMoviesUseCase(
    private val moviesRepository: MoviesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    operator fun invoke(region: String): Flow<List<Movie>> =
        moviesRepository.fetchMovies(region)
            .catch { println() }
            .flowOn(context = dispatcher)
}