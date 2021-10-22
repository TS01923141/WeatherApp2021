package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.WeatherApplication.Companion.appId
import com.example.weatherapp.WeatherApplication.Companion.countryName
import com.example.weatherapp.WeatherApplication.Companion.units
import com.example.weatherapp.model.weather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {

    val currentWeather by lazy { weatherRepository.currentWeather }

    fun refreshCurrentWeather() = viewModelScope.launch {
        weatherRepository.refreshCurrentWeather(countryName, appId, units)
    }
}