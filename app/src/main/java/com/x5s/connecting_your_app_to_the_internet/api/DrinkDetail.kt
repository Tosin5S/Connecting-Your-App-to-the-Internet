package com.x5s.connecting_your_app_to_the_internet.api

import com.squareup.moshi.Json

data class DrinkDetail(
    @Json(name = "strDrink")
    val drinkName:String,
    @Json(name = "strDrinkThumb")
    val drinkThumb:String,
    @Json(name = "idDrink")
    val drinkId:String,
    @Json(name = "strInstructions")
    val instruction:String


)
