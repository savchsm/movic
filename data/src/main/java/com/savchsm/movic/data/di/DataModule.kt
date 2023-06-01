package com.savchsm.movic.data.di

import com.savchsm.movic.data.datasource.RemoteMovieDataSource
import com.savchsm.movic.data.repository.MoviesRepositoryImpl
import com.savchsm.movic.data.repository.ProfileRepositoryImpl
import com.savchsm.movic.data.storage.ProfileStorage
import com.savchsm.movic.data.storage.sharedprefs.SharedPrefProfileStorage
import com.savchsm.movic.domain.repository.MoviesRepository
import com.savchsm.movic.domain.repository.ProfileRepository
import org.koin.dsl.module

val dataModule = module {
    single { RemoteMovieDataSource(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }

    single<ProfileStorage> { SharedPrefProfileStorage(get()) }
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
}