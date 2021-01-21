package com.aoinc.w4d2_a_weatherapi.model

data class Forecast(
    val current: Current,
    val daily: List<Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int

    // EMPTY TEST
//    val current: Current? = null,
//    val daily: List<Daily> = listOf(),
//    val lat: Double = 0.0,
//    val lon: Double = 0.0,
//    val timezone: String = "",
//    val timezone_offset: Int = 0
)