package com.example.feature_home.data.remote.api

import com.example.feature_home.data.remote.model.DealResponse
import retrofit2.http.GET

interface DealApi {
    @GET("deals")
    suspend fun getDeals(): List<DealResponse>
}