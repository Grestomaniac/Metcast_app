package com.example.android.network.service

import com.example.android.data.weather.Forecast
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    fun getWeather(@Query("q") cityName: String, @Query("units") TemperatureUnit: String ) : Deferred<Response<Forecast>>
}