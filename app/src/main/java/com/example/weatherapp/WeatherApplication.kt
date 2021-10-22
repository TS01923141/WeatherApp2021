package com.example.weatherapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApplication: Application() {

    companion object{
        const val countryName: String = "Taipei"
        const val appId: String = "0899273c10ddbaae0059f020ae69e421"
        const val units: String = "metric"
    }
}