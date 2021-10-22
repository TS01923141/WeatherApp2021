package com.example.weatherapp.model.weather.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface WeatherService {
    @GET("weather")
    suspend fun currentWeather(
        @Query("q") countryName: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ) : Response<WeatherDataNet>
}