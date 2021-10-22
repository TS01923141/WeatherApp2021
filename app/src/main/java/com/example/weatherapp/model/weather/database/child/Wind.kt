package com.example.weatherapp.model.weather.database.child

import androidx.room.Entity
import com.squareup.moshi.JsonClass

/*
    "wind": {
        "speed": 1.54,
        "deg": 310
    },
 */
@Entity
data class Wind constructor(
    val speed: Float,
    val deg: Int,
    val gust: Float
)