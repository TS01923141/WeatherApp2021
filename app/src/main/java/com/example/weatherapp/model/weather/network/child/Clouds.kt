package com.example.weatherapp.model.weather.network.child

import com.squareup.moshi.JsonClass

/*
    "clouds": {
        "all": 2
    },
 */
@JsonClass(generateAdapter = true)
data class Clouds (
    val all: Int
)