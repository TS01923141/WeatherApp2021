package com.example.weatherapp.model.weather.database.child

import androidx.room.Entity
import com.squareup.moshi.JsonClass
@Entity
data class Coord constructor(
    val lon: Double,
    val lat: Double
)