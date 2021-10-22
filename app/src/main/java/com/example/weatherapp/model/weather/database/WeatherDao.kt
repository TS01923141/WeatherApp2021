package com.example.weatherapp.model.weather.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
//    @Query("select * from weatherdataentity")
//    fun getWeatherDataList(): List<WeatherDataEntity>

    @Query("select * from weatherdataentity")
    fun getWeatherDataList(): LiveData<List<WeatherDataEntity>>

    @Query("select * from weatherdataentity where name = :name limit 1")
    fun getWeatherData(name: String): LiveData<WeatherDataEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(weatherDataList: List<WeatherDataEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherDataList: WeatherDataEntity)
}