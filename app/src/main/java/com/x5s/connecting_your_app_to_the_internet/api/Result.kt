package com.x5s.connecting_your_app_to_the_internet.api

import com.squareup.moshi.Json

data class Result(
        @Json(name = "name")
        val resultName:String,
        @Json(name = "status")
        val resultStatus:String,
        @Json(name = "species")
        val resultSpecies:String,
        @Json(name = "image")
        val resultImage:String
)


