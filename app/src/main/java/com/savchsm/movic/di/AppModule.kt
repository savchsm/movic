package com.savchsm.movic.di

import com.savchsm.movic.presentation.viewmodel.EditProfileViewModel
import com.savchsm.movic.presentation.viewmodel.FavouritesViewModel
import com.savchsm.movic.presentation.viewmodel.HomeViewModel
import com.savchsm.movic.presentation.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(fetchMoviesUseCase = get()) }
    viewModel { FavouritesViewModel() }
    viewModel { ProfileViewModel(getProfileUseCase = get()) }
    viewModel { EditProfileViewModel(saveProfileUseCase = get(), getProfileUseCase = get()) }
}
