package com.example.android.data.weather

import com.squareup.moshi.Json

data class Forecast(

        @field:Json(name = "cod")
        var cod: String,
        @field:Json(name = "message")
        var message: Float,
        @field:Json(name = "cnt")
        var cnt: Int,
        @field:Json(name = "list")
        var dataObject: List<DataObject>? = null,
        @field:Json(name = "city")
        var city: City
)