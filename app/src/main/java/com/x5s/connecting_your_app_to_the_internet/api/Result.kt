package com.x5s.connecting_your_app_to_the_internet.api

import com.squareup.moshi.Json

data class Result(

        @Json(name = "id")
        val resultId:String,
        @Json(name = "name")
        val resultName:String,
        @Json(name = "status")
        val resultStatus:String,
        @Json(name = "species")
        val resultSpecies:String,
        @Json(name = "image")
        val resultImage:String

)

//"strDrink": "1-900-FUK_MEUP",
//"strDrinkThumb": "https://www.thecocktaildb.com/images/media/drink/uxywyw1468877224.jpg",
//"idDrink": "15395"
