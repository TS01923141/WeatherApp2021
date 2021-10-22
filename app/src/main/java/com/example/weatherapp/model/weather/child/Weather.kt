package com.example.weatherapp.model.weather.child

import com.squareup.moshi.JsonClass

/*
        {
            "id": 800,
            "main": "Clear",
            "description": "clear sky",
            "icon": "01d"
        }
 */
data class Weather (
    val id: Int,
    val main : String,
    val description: String,
    val icon : String
)