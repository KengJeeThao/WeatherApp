package com.example.weatherapp.models

import com.squareup.moshi.Json


data class City(
    @Json(name = "timezone") val timeZone: Int,
)

data class ForecastTemperatures(
    @Json(name = "max") val maxTemperature: String,
    @Json(name = "min") val minTemperature: String,
)


data class DateTime(
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val temperatures: ForecastTemperatures,
    )

data class WeatherIcon(
    @Json(name = "icon") val iconName: String
)


data class Forecastsdata(
    @Json(name = "list") val timeData: List<DateTime>,
    @Json(name = "weather") val weatherIconImage: List<WeatherIcon>,
    @Json(name = "city") val city: City,
)