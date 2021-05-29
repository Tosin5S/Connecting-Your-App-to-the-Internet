package com.x5s.connecting_your_app_to_the_internet

import com.squareup.moshi.Json

data class Result(

    @Json(name = "name")
    val name:String? = null,
    @Json(name = "status")
    val status:String? = null,
    @Json(name = "species")
    val species:String? = null,
    @Json(name = "image")
    val image:String? = null
)