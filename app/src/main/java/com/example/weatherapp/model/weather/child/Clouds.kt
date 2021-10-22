package com.example.weatherapp.model.weather.child

import com.squareup.moshi.JsonClass

/*
    "clouds": {
        "all": 2
    },
 */
data class Clouds (
    val all: Int
)