package com.savchsm.movic.data.repository

import com.savchsm.movic.data.common.toProfile
import com.savchsm.movic.data.common.toProfileDTO
import com.savchsm.movic.data.storage.ProfileStorage
import com.savchsm.movic.domain.models.Profile
import com.savchsm.movic.domain.repository.ProfileRepository


class ProfileRepositoryImpl(
    private val profileStorage: ProfileStorage
) : ProfileRepository {

    override fun getProfileData(id: String): Profile? = profileStorage.get(id)?.toProfile()
    override fun saveProfileData(profile: Profile): Boolean = profileStorage.save(profile.toProfileDTO())
}