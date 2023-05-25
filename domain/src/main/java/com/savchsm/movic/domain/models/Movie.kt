package com.savchsm.movic.domain.models

data class Movie(
    val id: String,
    val title: String,
    val url: String,
    val genre: String,
    val country: String,
    val year: String
)
