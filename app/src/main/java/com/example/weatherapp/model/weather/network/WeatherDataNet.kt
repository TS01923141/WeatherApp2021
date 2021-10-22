package com.example.weatherapp.model.weather.network

import com.example.weatherapp.model.extension.empty
import com.example.weatherapp.model.weather.WeatherData
import com.example.weatherapp.model.weather.network.child.Clouds
import com.example.weatherapp.model.weather.network.child.Coord
import com.example.weatherapp.model.weather.network.child.Main
import com.example.weatherapp.model.weather.network.child.Sys
import com.example.weatherapp.model.weather.network.child.Weather
import com.example.weatherapp.model.weather.network.child.Wind
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDataNet(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int?,
    val wind: Wind?,
    val clouds: Clouds?,
    val dt: Long?,
    val sys: Sys?,
    val timezone: Int?,
    val id: Int?,
    val name: String?,
    val cod: Int?){

    companion object {
        val empty = WeatherDataNet(
            Coord(0.0, 0.0),
            arrayListOf(),
            String.empty(),
            Main(0f, 0f, 0f, 0f, 0, 0),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }

    fun asGeneralModel(): WeatherData {
        return WeatherData.fromNet(this)
    }
}