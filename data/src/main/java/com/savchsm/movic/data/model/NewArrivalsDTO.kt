package com.savchsm.movic.data.model

import com.savchsm.movic.domain.models.Movie

data class NewArrivalsDTO(
    val page: Int?,
    val results: List<Result>?
) {
    data class Result(
        val genre: List<String?>?,
        val imageurl: List<String?>?,
        val imdbid: String?,
        val imdbrating: Double?,
        val language: List<String?>?,
        val released: Int?,
        val runtime: String?,
        val synopsis: String?,
        val title: String?,
        val type: String?
    )
}

fun NewArrivalsDTO.Result.toMovie() = Movie(
    id = this.imdbid.orEmpty(),
    title = this.title.orEmpty(),
    url = this.imageurl?.first().orEmpty(),
    genre = this.genre?.first().orEmpty(),
    country = "",
    year = this.released.toString()
)