package com.example.mycurrency.network

import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {
    @GET("convert")
    fun getConvert(
        @Query("access_key") access_key: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: Int
    )
}