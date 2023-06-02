package com.savchsm.movic.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.domain.usecase.GetProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {

    val profile: Flow<Profile> = flow {
        val result = getProfileUseCase.execute("MY_PROFILE")
        result?.let { emit(result) }
    }.flowOn(Dispatchers.IO)
}