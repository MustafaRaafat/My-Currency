package com.example.mycurrency.network

import com.example.mycurrency.models.LatestDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {
    @GET("latest")
    suspend fun getLatest(
        @Query("access_key") access_key: String,
        @Query("symbols") symbols: String
    ): LatestDataModel
}