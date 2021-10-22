package com.example.weatherapp.model.weather.database.child

import androidx.room.Entity
import com.squareup.moshi.JsonClass

/*
    "clouds": {
        "all": 2
    },
 */
@Entity
data class Clouds constructor(
    val all: Int
)