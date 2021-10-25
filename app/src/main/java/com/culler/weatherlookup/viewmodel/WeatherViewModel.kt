package com.culler.weatherlookup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.culler.weatherlookup.model.WeatherInformation

class WeatherViewModel : ViewModel() {
    var weatherList = MutableLiveData<List<WeatherInformation>>()
    var newlist = arrayListOf<WeatherInformation>()

    fun add(weatherInformation: WeatherInformation) {
        newlist.add(weatherInformation)
        weatherList.value = newlist
    }

    fun addAll(weathers: List<WeatherInformation>) {
        newlist.addAll(weathers)
        weatherList.value = newlist
    }
}