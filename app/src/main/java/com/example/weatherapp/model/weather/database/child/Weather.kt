package com.example.weatherapp.model.weather.database.child

import androidx.room.Entity
import com.squareup.moshi.JsonClass

/*
        {
            "id": 800,
            "main": "Clear",
            "description": "clear sky",
            "icon": "01d"
        }
 */
@Entity
data class Weather constructor(
    val id: Int,
    val main : String,
    val description: String,
    val icon : String
)