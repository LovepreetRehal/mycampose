package com.example.mycompose.retrofit

import com.example.mycompose.model.LoginRequest
import com.example.mycompose.model.LoginResponse
import com.example.mycompose.model.SignUpRequest
import com.example.mycompose.model.SignUpResponce
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PropertyApi {



    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("signup")
    suspend fun signup(@Body loginRequest: SignUpRequest): Response<SignUpResponce>

    @GET("properties")
    suspend fun getProperty(): PropertyListResponse
    @GET("properties/{id}")
    suspend fun getPropertyDetails(@Path("id") id: String): PropertyDetailsResponse
}