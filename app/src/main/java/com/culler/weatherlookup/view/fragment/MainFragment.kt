package com.culler.weatherlookup.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.culler.weatherlookup.R
import com.culler.weatherlookup.model.OpenWeather
import com.culler.weatherlookup.service.ApiService
import com.culler.weatherlookup.view.activity.WeatherActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        private const val apiKey: String = "65d00499677e59496ca2f318eb68c049"
        private const val WEATHER_INFO: String = "weather_info"
    }

    private lateinit var edtCityName: EditText
    private lateinit var btnLookUp: Button

    override
    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override
    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view)
    }

    private fun initUi(view: View) {
        edtCityName = view.findViewById(R.id.city_name)
        btnLookUp = view.findViewById(R.id.look_up)
        btnLookUp.setOnClickListener(View.OnClickListener {
            fetchWeatherData()
        })
    }

    private fun fetchWeatherData() {

        val searchValue = edtCityName.text.toString()

        if (searchValue.isEmpty()) {
            Toast.makeText(
                context, "Please enter search value",
                Toast.LENGTH_LONG
            ).show()
        } else {
            getWeatherData(searchValue);
        }
    }

    private fun getWeatherData(searchValue: String) {
        val call = ApiService.getInstance()
            .getWeatherInformation(searchValue, apiKey)

        call.enqueue(object : Callback<OpenWeather> {
            override
            fun onResponse(
                call: Call<OpenWeather>,
                response: Response<OpenWeather>
            ) {
                if (response.code() == 200) {
                    val intent = Intent(context, WeatherActivity::class.java).apply {
                        putExtra(WEATHER_INFO, response.body())
                    }
                    startActivity(intent)

                } else {
                    Toast.makeText(
                        context, "We are facing some problem to fetch the weather",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override
            fun onFailure(call: Call<OpenWeather>, t: Throwable) {
                Log.e("ss", "error : " + t.message)
            }
        })
    }

}