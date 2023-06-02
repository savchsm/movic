package com.savchsm.movic.di

import com.savchsm.movic.domain.usecase.FetchMoviesUseCase
import com.savchsm.movic.domain.usecase.GetProfileUseCase
import com.savchsm.movic.domain.usecase.SaveProfileUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { FetchMoviesUseCase(get()) }
    factory { GetProfileUseCase(get()) }
    factory { SaveProfileUseCase(get()) }
}