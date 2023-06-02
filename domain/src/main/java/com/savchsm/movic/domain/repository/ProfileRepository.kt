package com.savchsm.movic.domain.repository

import com.savchsm.movic.domain.models.Profile

interface ProfileRepository {
    fun getProfileData(id: String): Profile?
    fun saveProfileData(profile: Profile): Boolean
}