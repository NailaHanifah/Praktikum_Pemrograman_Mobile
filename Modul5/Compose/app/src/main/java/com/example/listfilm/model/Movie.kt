package com.example.listfilm.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    @SerialName("poster_path") val posterPath: String,
    val overview: String
)
