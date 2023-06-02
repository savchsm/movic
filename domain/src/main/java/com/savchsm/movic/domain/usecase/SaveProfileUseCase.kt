package com.savchsm.movic.domain.usecase

import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.domain.repository.ProfileRepository

class SaveProfileUseCase(private val profileRepository: ProfileRepository) {

    operator fun invoke(profile: Profile): Boolean = profileRepository.saveProfileData(profile)
}