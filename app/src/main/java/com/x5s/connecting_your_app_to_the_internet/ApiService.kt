package com.x5s.connecting_your_app_to_the_internet

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://rickandmortyapi.com"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL).build()

interface ApiService{

    @GET("/api/character")
    fun getAllData(): Call<List<Result?>?>

}


object Api{
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
