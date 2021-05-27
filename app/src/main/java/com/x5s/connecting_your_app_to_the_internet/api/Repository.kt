package com.x5s.connecting_your_app_to_the_internet.api

class Repository(private val apiService: ApiService) {

    suspend fun getResults(results: String)  = apiService.getResults(results)

}