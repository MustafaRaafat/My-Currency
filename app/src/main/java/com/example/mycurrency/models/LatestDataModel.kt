package com.example.mycurrency.models

data class LatestDataModel(
    var success: Boolean,
    var timestamp: Int,
    var base: String,
    var date: String,
    var rates: Rates
) {
    data class Rates(var AED: Double)
}