package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.weather.WeatherData
import com.example.weatherapp.model.weather.repository.WeatherRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
    Room, LiveData, Hilt, Retrofit, Coroutines, Moshi

    權限
    Application設定Hilt

    Retrofit取得天氣
    1.WeatherData
    2.WeatherDataNet
    3.WeatherDataResponse
    4.RetrofitUtils
    5.WeatherRepository
    6.單元測試

    取得天氣後儲存進Room
    1.WeatherDataEntity
    2.WeatherDatabase
    3.WeatherDao
    4.單元測試

    ViewModel
    1.Hilt
    2.串接Repository，取得天氣時會先去抓線上資料存到Room內再透過Room去得最新資料
    3.離線時取得Room資料
    4.天氣資料為LiveData
    5.單元測試

    Activity
    1.串ViewBinding
    2.串ViewModel
    3.每次onResume取得資料
 */

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var weatherRepository: WeatherRepository

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(viewModel) {
            currentWeather.observe(this@MainActivity, ::handleWeatherChange)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshCurrentWeather()
    }

    @SuppressLint("SetTextI18n")
    private fun handleWeatherChange(weatherData: WeatherData?){
        if (weatherData == null) return
        binding.textView.text = "${weatherData.main.temp}°C"
    }
}