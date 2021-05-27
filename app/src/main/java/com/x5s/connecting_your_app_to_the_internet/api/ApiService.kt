package com.x5s.connecting_your_app_to_the_internet.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val BASE_URL = "https://rickandmortyapi.com/api/character/"

interface ApiService{

    @GET("")
    suspend fun getResults(@Query("page")results:String):ResultResponse

}

val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL).build()

object Api{
    val apiService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
