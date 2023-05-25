package com.savchsm.movic.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.savchsm.movic.domain.models.Movie
import com.savchsm.movic.domain.usecase.FetchMoviesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val fetchMoviesUseCase: FetchMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun fetchMovies(region: String = "US") =
        fetchMoviesUseCase.invoke(region)
            .onEach { _movies.value = it }
            .catch { println() }
            .launchIn(viewModelScope)
}