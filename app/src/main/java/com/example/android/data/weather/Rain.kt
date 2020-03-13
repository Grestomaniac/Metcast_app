package com.example.android.data.weather

import com.squareup.moshi.Json

data class Rain(

        @field:Json(name = "3hr")
        var _3hr: Float
)