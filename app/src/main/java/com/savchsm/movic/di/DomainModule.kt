package com.savchsm.movic.di

import com.savchsm.movic.domain.usecase.FetchMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { FetchMoviesUseCase(get()) }
}