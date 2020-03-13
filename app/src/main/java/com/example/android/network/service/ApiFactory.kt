package com.example.android.network.service

import com.example.android.data.AppConstants

object ApiFactory{

    val weatherHolderApi: WeatherApi = RetrofitFactory.retrofit(AppConstants.WEATHER_BASE_URL)
            .create(WeatherApi::class.java)
}