package com.example.weatherapp.model.weather.repository

import com.example.weatherapp.model.weather.WeatherData
import com.example.weatherapp.model.weather.database.WeatherDatabase
import com.example.weatherapp.model.weather.network.WeatherDataNet
import com.example.weatherapp.model.weather.network.WeatherService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import retrofit2.Response
import retrofit2.Retrofit

internal class WeatherRepositoryTest{

    private lateinit var weatherRepository: WeatherRepository

    @MockK private lateinit var service: WeatherService
    @MockK private lateinit var database: WeatherDatabase
    @MockK private lateinit var weatherResponse : Response<WeatherDataNet>

    private val name = "test"
    private val appid = "testAppId"
    private val unit = "metric"

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        weatherRepository = WeatherRepository(service, database)
    }

    @Test
    fun `should return fail when response not successful `() {
        every { weatherResponse.isSuccessful } returns false
        coEvery { service.currentWeather(name, appid, unit) } returns weatherResponse
        runBlocking {
            val weatherData = weatherRepository.getCurrentWeather(name,appid,unit)
            assertEquals(weatherData, null)
        }
    }

    @Test
    fun `should return fail when response body is null`() {
        every { weatherResponse.isSuccessful } returns true
        every {  weatherResponse.body() } returns null
        coEvery { service.currentWeather(name, appid, unit) } returns weatherResponse
        runBlocking {
            val weatherData = weatherRepository.getCurrentWeather(name, appid, unit)
            assertEquals(weatherData, null)
        }
    }

    @Test
    fun `should return WeatherData from service`() {
        every { weatherResponse.isSuccessful } returns true
        every {  weatherResponse.body() } returns WeatherDataNet.empty
        coEvery { service.currentWeather(name, appid, unit) } returns weatherResponse
        runBlocking {
            val weatherData = weatherRepository.getCurrentWeather(name, appid, unit)
            assertEquals(weatherData, WeatherData.empty)
        }
    }
}