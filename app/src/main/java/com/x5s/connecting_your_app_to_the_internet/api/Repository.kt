package com.x5s.connecting_your_app_to_the_internet.api

class Repository(private val apiService: ApiService) {

    suspend fun getDrink(drink: String)  = apiService.getDrinks(drink)

    suspend fun getDrinkDetails(id:String) = apiService.getDrinkDetails(id)
}