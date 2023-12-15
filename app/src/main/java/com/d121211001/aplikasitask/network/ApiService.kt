package com.d121211001.aplikasitask.network

import retrofit2.http.GET

interface ApiService {
    @GET("random")
    suspend fun getQuotes(): ApiResponse
}