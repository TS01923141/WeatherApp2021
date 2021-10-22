package com.example.weatherapp.model.weather.database

import android.content.Context
import androidx.room.*

@Database(entities = [WeatherDataEntity::class], version = 1)
@TypeConverters(WeatherDataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val weatherDao: WeatherDao
}

private lateinit var INSTANCE : WeatherDatabase

fun getDatabase(context: Context): WeatherDatabase {
    synchronized(WeatherDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
            WeatherDatabase::class.java,
            "weathers").build()
        }
    }
    return INSTANCE
}