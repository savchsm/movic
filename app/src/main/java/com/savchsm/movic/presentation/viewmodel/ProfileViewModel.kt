package com.savchsm.movic.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.domain.usecase.GetProfileUseCase

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase
): ViewModel() {

    private val _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile>
        get() = _profile

    fun getProfileData() {
        val result = getProfileUseCase.execute(id = "MY_PROFILE")
        result?.let { _profile.value = it }
    }
}