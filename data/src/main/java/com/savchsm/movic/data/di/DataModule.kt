package com.savchsm.movic.data.di

import com.savchsm.movic.data.datasource.RemoteMovieDataSource
import com.savchsm.movic.data.repository.MoviesRepositoryImpl
import com.savchsm.movic.domain.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    single { RemoteMovieDataSource(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
}