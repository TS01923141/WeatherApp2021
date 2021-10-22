package com.example.weatherapp.model.weather.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.model.weather.WeatherData
import com.example.weatherapp.model.weather.database.WeatherDatabase
import com.example.weatherapp.model.weather.network.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject

private const val TAG = "WeatherRepository"

class WeatherRepository @Inject constructor(private val service: WeatherService, private val database: WeatherDatabase) {
    val currentWeather: LiveData<WeatherData> =
            Transformations.map(database.weatherDao.getWeatherData(WeatherApplication.countryName)) {
                it?.asGeneralModel()
            }

    suspend fun refreshCurrentWeather(countryName: String, appId: String, units: String) {
        withContext(Dispatchers.IO) {
            val weatherData = getCurrentWeather(countryName, appId, units)
            if (weatherData != null) {
                database.weatherDao.insert(weatherData.asDatabaseModel())
            }
        }
    }

    suspend fun getCurrentWeather(countryName: String, appId: String, units: String): WeatherData? =
        withContext(Dispatchers.IO) {
            try {
                val response = service.currentWeather(countryName, appId, units)
                if (response.isSuccessful) {
                    Log.d(
                        TAG,
                        "getCurrentWeather: weatherData: {${response.body()?.asGeneralModel()}}"
                    )
                    response.body()?.asGeneralModel()
                } else {
                    Log.d(TAG, "getCurrentWeather: response is fail")
                    null
                }
            }catch (e: UnknownHostException){
                e.printStackTrace()
                null
            }
        }
}