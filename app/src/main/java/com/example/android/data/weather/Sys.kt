package com.example.android.data.weather

import com.squareup.moshi.Json

data class Sys(

        @field:Json(name = "pod")
        var pod: String
)