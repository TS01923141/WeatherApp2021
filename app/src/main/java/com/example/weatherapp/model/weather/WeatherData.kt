package com.example.weatherapp.model.weather

import com.example.weatherapp.model.extension.empty
import com.example.weatherapp.model.weather.database.WeatherDataEntity
import com.example.weatherapp.model.weather.database.child.Clouds
import com.example.weatherapp.model.weather.database.child.Coord
import com.example.weatherapp.model.weather.database.child.Main
import com.example.weatherapp.model.weather.database.child.Sys
import com.example.weatherapp.model.weather.database.child.Weather
import com.example.weatherapp.model.weather.database.child.Wind
import com.example.weatherapp.model.weather.network.WeatherDataNet

data class WeatherData(
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
        val empty = WeatherData(
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

        fun fromNet(weatherNet: WeatherDataNet) = WeatherData(
            Coord(weatherNet.coord.lat, weatherNet.coord.lon),
            weatherNet.weather.map { Weather(it.id, it.main, it.description, it.icon) },
            weatherNet.base,
            Main(weatherNet.main.temp, weatherNet.main.feels_like, weatherNet.main.temp_min, weatherNet.main.temp_max, weatherNet.main.pressure, weatherNet.main.humidity),
            weatherNet.visibility,
            if (weatherNet.wind == null) null else Wind(weatherNet.wind.speed, weatherNet.wind.deg, weatherNet.wind.gust),
            if (weatherNet.clouds == null) null else Clouds(weatherNet.clouds.all),
            weatherNet.dt,
            if (weatherNet.sys == null) null else Sys(weatherNet.sys.type, weatherNet.sys.id, weatherNet.sys.country, weatherNet.sys.sunrise, weatherNet.sys.sunset),
            weatherNet.timezone,
            weatherNet.id,
            weatherNet.name,
            weatherNet.cod
        )
    }

    fun asDatabaseModel() : WeatherDataEntity = WeatherDataEntity(
        Coord(this.coord.lat, this.coord.lon),
        this.weather.map { Weather(it.id, it.main, it.description, it.icon) },
        this.base,
        Main(this.main.temp, this.main.feels_like, this.main.temp_min, this.main.temp_max, this.main.pressure, this.main.humidity),
        this.visibility,
        if (this.wind == null) null else Wind(this.wind.speed, this.wind.deg, this.wind.gust),
        if (this.clouds == null) null else Clouds(this.clouds.all),
        this.dt,
        if (this.sys == null) null else Sys(this.sys.type, this.sys.id, this.sys.country, this.sys.sunrise, this.sys.sunset),
        this.timezone,
        this.id,
        this.name,
        this.cod
    )
}