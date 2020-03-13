package com.example.android.data

import com.example.android.recyclerview.BuildConfig

object AppConstants{

    const val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val TemperatureUnit = "metric"
    const val YakutskCity = "Yakutsk"
    const val MoscowCity = "Moscow"
    const val SpbCity = "Mshinskaya"
    var weatherApiKey = BuildConfig.WEATHER_API_KEY

}