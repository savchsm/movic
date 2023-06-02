package com.savchsm.movic.domain.usecase

import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.domain.repository.ProfileRepository

class GetProfileUseCase(
    private val profileRepository: ProfileRepository
) {
    fun execute(id: String): Profile? = profileRepository.getProfileData(id)
}