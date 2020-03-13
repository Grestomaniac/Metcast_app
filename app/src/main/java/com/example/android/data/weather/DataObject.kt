package com.example.android.data.weather

import com.squareup.moshi.Json

data class DataObject(

        @field:Json(name = "dt")
        var dt: Int,
        @field:Json(name = "main")
        var main: Main,
        @field:Json(name = "weather")
        var weather: List<Weather>? = null,
        @field:Json(name = "clouds")
        var clouds: Clouds,
        @field:Json(name = "wind")
        var wind: Wind,
        @field:Json(name = "sys")
        var sys: Sys,
        @field:Json(name = "dt_txt")
        var dt_txt: String
)