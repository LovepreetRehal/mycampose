package com.example.mycompose.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface PropertyApi {
    @GET("properties")
    suspend fun getProperty(): PropertyListResponse
    @GET("properties/{id}")
    suspend fun getPropertyDetails(@Path("id") id: String): PropertyDetailsResponse
}