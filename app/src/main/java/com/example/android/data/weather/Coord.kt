package com.example.android.data.weather

import com.squareup.moshi.Json

data class Coord(

        @field:Json(name = "lat")
        var lat: Float,
        @field:Json(name = "lon")
        var lon: Float
)