package com.example.mycurrency.models

data class LatestDataModel(
    var success: Boolean,
    var timestamp: Int,
    var base: String,
    var date: String,
    var rates: Rates
) {
    data class Rates(
        var USD: Double,
        var EGP: Double,
        var AUD: Double,
        var CAD: Double,
        var PLN: Double,
        var MXN: Double
    )
}