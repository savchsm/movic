package com.savchsm.movic.data.api

import com.savchsm.movic.data.model.NewArrivalsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("getnew")
    suspend fun fetchNewMovies(
        @Query("region") region: String? = "US"
    ): NewArrivalsDTO
}