package com.example.android.data

data class WeatherHolder (
    val now: Int,
    val now_dt: String
)

data class WeatherHolderResponse(
        val results: List<WeatherHolder>
)