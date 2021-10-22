package com.example.weatherapp.model.weather.database

import androidx.room.TypeConverter
import com.example.weatherapp.model.weather.database.child.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type

class WeatherDataConverter {

    //Coord

    @TypeConverter
    fun fromCoord(coord: Coord?): String? {
        if (coord == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Coord> = moshi.adapter(Coord::class.java)
        return jsonAdapter.toJson(coord)
    }

    @TypeConverter
    fun toCoord(coordString: String?): Coord? {
        if (coordString == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Coord> = moshi.adapter(Coord::class.java)
        return jsonAdapter.fromJson(coordString)
    }

    //List<Weather>

    @TypeConverter
    fun fromWeatherList(weatherList: List<Weather>?): String? {
        if (weatherList == null) { return null }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val listWeatherData: Type = Types.newParameterizedType(MutableList::class.java, Weather::class.java)
        val jsonAdapter : JsonAdapter<List<Weather>> = moshi.adapter(listWeatherData)
        return jsonAdapter.toJson(weatherList)
    }

    @TypeConverter
    fun toWeatherList(weatherString: String?): List<Weather>? {
        if (weatherString == null) { return null }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val listWeatherData: Type = Types.newParameterizedType(MutableList::class.java, Weather::class.java)
        val jsonAdapter : JsonAdapter<List<Weather>> = moshi.adapter(listWeatherData)
        return jsonAdapter.fromJson(weatherString)
    }

    //Main

    @TypeConverter
    fun fromMain(main: Main?): String? {
        if (main == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Main> = moshi.adapter(Main::class.java)
        return jsonAdapter.toJson(main)
    }

    @TypeConverter
    fun toMain(mainString: String?): Main? {
        if (mainString == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Main> = moshi.adapter(Main::class.java)
        return jsonAdapter.fromJson(mainString)
    }

    //Wind

    @TypeConverter
    fun fromWind(wind: Wind?): String? {
        if (wind == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Wind> = moshi.adapter(Wind::class.java)
        return jsonAdapter.toJson(wind)
    }

    @TypeConverter
    fun toWind(windString: String?): Wind? {
        if (windString == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Wind> = moshi.adapter(Wind::class.java)
        return jsonAdapter.fromJson(windString)
    }

    //Clouds

    @TypeConverter
    fun fromClouds(clouds: Clouds?): String? {
        if (clouds == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Clouds> = moshi.adapter(Clouds::class.java)
        return jsonAdapter.toJson(clouds)
    }

    @TypeConverter
    fun toClouds(cloudsString: String?): Clouds? {
        if (cloudsString == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Clouds> = moshi.adapter(Clouds::class.java)
        return jsonAdapter.fromJson(cloudsString)
    }

    //Sys

    @TypeConverter
    fun fromSys(sys: Sys?): String? {
        if (sys == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Sys> = moshi.adapter(Sys::class.java)
        return jsonAdapter.toJson(sys)
    }

    @TypeConverter
    fun toSys(sysString: String?): Sys? {
        if (sysString == null) {
            return null
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Sys> = moshi.adapter(Sys::class.java)
        return jsonAdapter.fromJson(sysString)
    }
}