package com.example.mycurrency.repository

import com.example.mycurrency.network.CurrencyApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val currencyApiService: CurrencyApiService) {
    private val ApiKey = "c3cc0b311ac9e90db9f85af995c87b7e"

    fun getLatestData() = flow {
        emit(currencyApiService.getLatest(ApiKey))
    }
}