package com.example.weatherapp.model.weather.network.child

import com.squareup.moshi.JsonClass

/*
    "wind": {
        "speed": 1.54,
        "deg": 310
    },
 */
@JsonClass(generateAdapter = true)
data class Wind (
    val speed: Float,
    val deg: Int,
    val gust: Float
)