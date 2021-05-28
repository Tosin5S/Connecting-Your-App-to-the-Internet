package com.x5s.connecting_your_app_to_the_internet

import com.squareup.moshi.Json

 abstract class Property : List<Result?> {
    @Json(name = "results")
    val list: List<Result>? = null
}
