package com.savchsm.movic.data.model

import com.google.gson.annotations.SerializedName
import com.savchsm.movic.domain.models.Movie

data class FilteredMoviesDTO(
    val Response: String?,
    @SerializedName("Search")
    val movies: List<Search>?,
    val totalResults: String?
) {
    data class Search(
        val Poster: String?,
        val Title: String?,
        val Type: String?,
        val Year: String?,
        val imdbID: String?
    )
}

fun FilteredMoviesDTO.Search.toMovie() = Movie(
    id = this.imdbID.orEmpty(),
    title = this.Title.orEmpty(),
    url = this.Poster.orEmpty(),
    genre = this.Type.orEmpty(),
    country = "",
    year = this.Year.orEmpty()
)