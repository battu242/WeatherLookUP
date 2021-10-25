package com.culler.weatherlookup.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.culler.weatherlookup.R
import com.culler.weatherlookup.model.OpenWeather
import com.culler.weatherlookup.view.adapter.WeatherAdapter
import com.culler.weatherlookup.viewmodel.WeatherViewModel


class WeatherActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: WeatherViewModel
    private lateinit var mainrecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_activity)
        initUi()
    }

    private fun initUi() {
        mainrecycler = findViewById(R.id.list_weathers)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        mainrecycler.layoutManager = viewManager
        val mDividerItemDecoration: DividerItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mainrecycler.addItemDecoration(mDividerItemDecoration)

        viewModel.weatherList.observe(this, Observer {
            mainrecycler.adapter = WeatherAdapter(viewModel, it, this)
        })

        val bundle = intent?.extras
        val openweather = bundle?.getParcelable<OpenWeather>("weather_info")
        viewModel.addAll(openweather!!.openWeathers)

    }
}