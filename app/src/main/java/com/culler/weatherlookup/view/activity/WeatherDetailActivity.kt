package com.culler.weatherlookup.view.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.culler.weatherlookup.R
import com.culler.weatherlookup.model.WeatherInformation


class WeatherDetailActivity : AppCompatActivity() {

    private lateinit var temparture: TextView
    private lateinit var feelsLike: TextView
    private lateinit var weather: TextView
    private lateinit var weatherDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_detail_activity)
        initUi()
    }

    private fun initUi() {
        temparture = findViewById(R.id.txt_detail_temp)
        feelsLike = findViewById(R.id.txt_feels_like)
        weather = findViewById(R.id.txt_weather_detail)
        weatherDetail = findViewById(R.id.txt_weather_description)

        val bundle = intent?.extras
        val WeatherInformation = bundle?.getParcelable<WeatherInformation>("weather_item")

        temparture.text = WeatherInformation?.main?.temperature.toString()
        val feelsValue = String.format(getString(R.string.feels_like), WeatherInformation?.main?.feelsLike)
        feelsLike.text = feelsValue

        weather.text = WeatherInformation?.weather?.get(0)?.main
        weatherDetail.text = WeatherInformation?.weather?.get(0)?.description
    }
}