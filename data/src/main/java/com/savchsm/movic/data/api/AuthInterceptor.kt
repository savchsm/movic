package com.savchsm.movic.data.api

import com.savchsm.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", BuildConfig.MOVIES_API_KEY)
            .addHeader("X-RapidAPI-Host", "ott-details.p.rapidapi.com")
            .build()
        return chain.proceed(newRequest)
    }
}