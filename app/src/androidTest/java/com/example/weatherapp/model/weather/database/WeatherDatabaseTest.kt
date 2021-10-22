package com.example.weatherapp.model.weather.database

import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.weatherapp.model.utils.LiveDataTestUtil
import com.example.weatherapp.model.utils.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.internal.tls.OkHostnameVerifier.verify
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.lang.Exception

internal class WeatherDatabaseTest {

    private lateinit var dao : WeatherDao
    private lateinit var db: WeatherDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        //im-memory，當執行結束時就會清掉，不會存在app/手機內
        db = Room.inMemoryDatabaseBuilder(context, WeatherDatabase::class.java)
                //允許在MainThread執行，測試用
            .allowMainThreadQueries()
            .build()
        dao = db.weatherDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

//    @Test
//    @Throws(Exception::class)
//    fun insertAndQuery() {
//        val weatherDataEntity = WeatherDataEntity.empty
//        dao.insert(weatherDataEntity)
//        val entityList = dao.getWeatherDataList()
//        Assert.assertEquals(entityList?.size, 1)
//    }

    @Test
    @Throws(Exception::class)
    fun insertAndQueryLiveData() {
        GlobalScope.launch(Dispatchers.Main) {
            val weatherDataEntity = WeatherDataEntity.empty
            dao.getWeatherDataList().observeForever {
                Assert.assertEquals(it.size, 1)
            }
            dao.insert(weatherDataEntity)
        }
    }
}