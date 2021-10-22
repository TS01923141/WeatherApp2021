package com.example.weatherapp.model.weather.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.model.extension.empty
import com.example.weatherapp.model.weather.WeatherData
import com.example.weatherapp.model.weather.database.child.Clouds
import com.example.weatherapp.model.weather.database.child.Coord
import com.example.weatherapp.model.weather.database.child.Main
import com.example.weatherapp.model.weather.database.child.Sys
import com.example.weatherapp.model.weather.database.child.Weather
import com.example.weatherapp.model.weather.database.child.Wind

@Entity
data class WeatherDataEntity (
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
    @PrimaryKey val id: Int?,
    val name: String?,
    val cod: Int?){

    companion object {
        val empty = WeatherDataEntity(
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

    fun asGeneralModel() = WeatherData(
        Coord(coord.lon, coord.lat),
        weather.map { Weather(it.id,it.main, it.description, it.icon) },
        base,
        Main(main.temp, main.feels_like, main.temp_min, main.temp_max, main.pressure, main.humidity),
        visibility,
        if (wind != null) Wind(wind.speed, wind.deg, wind.gust) else null,
        if (clouds != null) Clouds(clouds.all) else null,
        dt,
        if (sys != null) Sys(sys.type, sys.id, sys.country, sys.sunrise, sys.sunset) else null,
        timezone,
        id,
        name,
        cod
    )
}