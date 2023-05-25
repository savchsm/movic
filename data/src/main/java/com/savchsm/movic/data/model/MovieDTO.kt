package com.savchsm.movic.data.model

import com.savchsm.movic.domain.models.Movie

data class MovieDTO(
    val Actors: String?,
    val Awards: String?,
    val BoxOffice: String?,
    val Country: String?,
    val DVD: String?,
    val Director: String?,
    val Genre: String?,
    val Language: String?,
    val Metascore: String?,
    val Plot: String?,
    val Poster: String?,
    val Production: String?,
    val Rated: String?,
    val Ratings: List<Rating?>?,
    val Released: String?,
    val Response: String?,
    val Runtime: String?,
    val Title: String?,
    val Type: String?,
    val Website: String?,
    val Writer: String?,
    val Year: String?,
    val imdbID: String?,
    val imdbRating: String?,
    val imdbVotes: String?
) {
    data class Rating(
        val Source: String?,
        val Value: String?
    )
}

private fun MovieDTO.toMovie() = Movie(
    id = this.imdbID.orEmpty(),
    title = this.Title.orEmpty(),
    url = this.Poster.orEmpty(),
    genre = this.Genre.orEmpty(),
    country = this.Country.orEmpty(),
    year = this.Year.orEmpty()
)