package com.example.android.data.weather

import com.squareup.moshi.Json

data class Main(

        @field:Json(name = "temp")
        var temp: Float,
        @field:Json(name = "temp_min")
        var temp_min: Float,
        @field:Json(name = "temp_max")
        var temp_max: Float,
        @field:Json(name = "pressure")
        var pressure: Float,
        @field:Json(name = "sea_level")
        var seaLevel: Float,
        @field:Json(name = "grnd_level")
        var grndLevel: Float,
        @field:Json(name = "humidity")
        var humidity: Int,
        @field:Json(name = "temp_kf")
        var tempKf: Float
)