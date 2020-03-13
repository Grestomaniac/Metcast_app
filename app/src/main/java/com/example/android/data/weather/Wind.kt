package com.example.android.data.weather

import com.squareup.moshi.Json

data class Wind(

        @field: Json(name = "speed")
        var speed: Float,
        @field:Json(name = "deg")
        var deg: Float
)