package com.savchsm.movic.data.storage

import com.savchsm.movic.data.storage.model.ProfileDTO

interface ProfileStorage {
    fun get(id: String): ProfileDTO?
    fun save(profile: ProfileDTO): Boolean
}