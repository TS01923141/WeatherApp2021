package com.example.weatherapp.model.weather.child

import com.squareup.moshi.JsonClass

/*
    "wind": {
        "speed": 1.54,
        "deg": 310
    },
 */
data class Wind (
    val speed: Float,
    val deg: Int,
    val gust: Float
)