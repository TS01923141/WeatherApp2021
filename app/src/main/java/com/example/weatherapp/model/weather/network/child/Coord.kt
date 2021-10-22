package com.example.weatherapp.model.weather.network.child

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coord(
    val lon: Double,
    val lat: Double
)