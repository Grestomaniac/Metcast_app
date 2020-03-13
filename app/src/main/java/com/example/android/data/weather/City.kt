package com.example.android.data.weather

import com.squareup.moshi.Json

data class City(

        @field:Json(name = "id")
        val id: Int,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "coord")
        val coord: Coord,
        @field:Json(name = "country")
        val country: String,
        @field:Json(name = "population")
        val population: Int
)