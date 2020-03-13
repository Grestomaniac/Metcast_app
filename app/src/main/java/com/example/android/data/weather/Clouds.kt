package com.example.android.data.weather

import com.squareup.moshi.Json

data class Clouds(

        @field:Json(name = "all")
        var all: Int
)