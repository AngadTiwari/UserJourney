package com.example.userjournery.network

import com.example.userjournery.model.UserCategory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AppService {

    companion object {
        fun getAppService(): AppService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://enigmatic-coast-6264.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AppService::class.java)
        }
    }

    @GET("/categories")
    suspend fun getUserCategories(): Response<List<UserCategory>>
}