package com.x5s.connecting_your_app_to_the_internet.api

import com.squareup.moshi.Json

data class Drink(
    @Json(name = "strDrink")
    val drinkName:String,
    @Json(name = "strDrinkThumb")
    val drinkThumb:String,
    @Json(name = "idDrink")
    val drinkId:String
)

//"strDrink": "1-900-FUK_MEUP",
//"strDrinkThumb": "https://www.thecocktaildb.com/images/media/drink/uxywyw1468877224.jpg",
//"idDrink": "15395"
