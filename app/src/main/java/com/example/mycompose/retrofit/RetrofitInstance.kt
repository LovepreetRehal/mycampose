package com.example.mycompose.retrofit

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://rent.nightclubpool.com/api/"
//    private const val BASE_URL = "https://fake-json-api.mock.beeceptor.com/"


    private var header: Interceptor? = Interceptor { chain ->
        // Get the Authorization token dynamically or from storage
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxMCIsImp0aSI6ImJiMTg4Nzk0OGZmNDY2NzAwYWE0NDVmYzBmYzcwYzNmM2M2MmUwZDUxZmY1OTAxMDM4YzFkODNmMzQ2M2I3ZjdmNGY5ODhhMGI0MmYyOWQwIiwiaWF0IjoxNzM3NTMzMTIyLjkxOTk4LCJuYmYiOjE3Mzc1MzMxMjIuOTE5OTgyLCJleHAiOjE3NjkwNjkxMjIuOTEzMzQsInN1YiI6IjU0MSIsInNjb3BlcyI6W119.UYGHdCoAjTGidmEEKaqkqzyqEcc9QwcZLKRmYNI8UeaZOPxYMrIF0tR9p-x6QlfspVSXiyFP78D1ppCpZDEkaiPXJxubQWp_Gr_ONYqDe9_9n-Jp3ZiSLadnoZZjFiNAXLDuXKx-tMKFJ5mEkznkXnstHymlmHY8Y6KF55WSG2h8GLontg3u0w1qiclgTtj1-DFiI3hfUjhnYjc-R9TmqV42H7yGgn-P-oepCAyzWdCXJ7vVsnXZOJ2FfulKeTFOOoni_rNCtQFJvWHexTqv5F0GYSynQjzE752CyZhCmlJSrOYaiVEPJaPkvlRt92u8pSccA7Cj9Zy2XMI4SjGRZ4F2zBMkZdaEJXG-ATOUxSluTXSVjp62jg5Y0DmAAO9_niDsAZOQP9mc8uwun1MSE3zVasKh0AzXeHkXhpqWCXUzYPkmyG4Z5oETrEEMFZjGKl8iCnnutkJfqZoK5bxZaUgfU44gT4UXKdO3J7G1QPjxr6hXOzXaHZiRyBlnZ-_USkhAYIpiY7vSaLqvQmjJbKClDD0DUIlvrzOAnay6lr3RAteJQIVi82edz7E_cFiR1XxmH3W0AOTPBdHTG0HUaMr10GPA1eOlK1hhOARnrVnxibIx3PHmus22Js7pLDRw9pTanpYPg_lHEvQIs5avloQeis8jtub_muImWEujVr4" // replace with your dynamic token logic

        // Add any custom headers
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "Bearer $token") // Add Bearer token header dynamically
            .header("Custom-Header", "YourCustomValue") // Example of adding a custom header
            .build()

        chain.proceed(newRequest)
    }

    val api: PropertyApi by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(header!!) // Add the interceptor
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient) // Set the client with the interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PropertyApi::class.java)
    }
}
