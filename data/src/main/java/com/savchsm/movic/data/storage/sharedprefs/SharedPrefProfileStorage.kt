package com.savchsm.movic.data.storage.sharedprefs

import android.content.Context
import com.google.gson.Gson
import com.savchsm.movic.data.storage.ProfileStorage
import com.savchsm.movic.data.storage.model.ProfileDTO

private const val SHARED_PREFS_NAME = "shared_prefs_movic"

class SharedPrefProfileStorage(
    private val context: Context
): ProfileStorage {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_NAME, Context.MODE_PRIVATE
    )

    override fun get(id: String): ProfileDTO? {
        val result = sharedPreferences.getString(id, "")
        val profile = Gson().fromJson(result, ProfileDTO::class.java)
        return profile
    }

    override fun save(profile: ProfileDTO): Boolean {
        val data = Gson().toJson(profile).toString()
        sharedPreferences.edit().putString(profile.id, data).apply()
        return true
    }
}