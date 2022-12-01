package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.Forecastsdata
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "4d6384a89b5f2053860745fff021775f",
        @Query("units") units: String = "imperial",
        ) : CurrentConditions

    suspend fun getCurrentConditions1(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "4d6384a89b5f2053860745fff021775f",
        @Query("units") units: String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "4d6384a89b5f2053860745fff021775f",
        @Query("units") units: String = "imperial",
    ) : Forecastsdata

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastTemperatures(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "4d6384a89b5f2053860745fff021775f",
        @Query("units") unit: String = "imperial"
    ) : Forecastsdata

    abstract fun getForecastTemperatures(): Forecastsdata
    abstract fun getCurrentConditions(): CurrentConditions


}