package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.Forecastsdata
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "imperial",
        ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "imperial",
    ) : Forecastsdata

    abstract fun getCurrentConditions(): CurrentConditions
    abstract fun getForecastConditions(): Forecastsdata
}