package com.culler.weatherlookup.service

import com.culler.weatherlookup.model.OpenWeather
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/forecast")
    fun getWeatherInformation(
        @Query("q") city: String,
        @Query("appid") appId: String
    ): Call<OpenWeather>

    companion object {
        private const val baseUrl: String = "https://api.openweathermap.org/"
        var apiService: ApiService? = null

        fun getInstance(): ApiService {

            if (apiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}