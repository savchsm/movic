package com.savchsm.movic.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.domain.usecase.GetProfileUseCase
import com.savchsm.movic.domain.usecase.SaveProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditProfileViewModel(
    private val saveProfileUseCase: SaveProfileUseCase,
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {

    private val _condition = MutableLiveData<Boolean>()
    val condition: LiveData<Boolean>
        get() = _condition

    val profile: LiveData<Profile> = liveData {
        val result = getProfileUseCase.execute(id = "MY_PROFILE")
        result?.let { emit(it) }
    }.distinctUntilChanged()

    fun saveProfileData(newProfile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            if (newProfile != profile.value) saveProfileUseCase.invoke(newProfile)
        }
        _condition.value = true
    }

    fun checkDataChanged(newProfile: Profile) {
        _condition.value = newProfile == profile.value
    }
}