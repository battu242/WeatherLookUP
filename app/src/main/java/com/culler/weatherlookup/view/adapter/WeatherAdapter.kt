package com.culler.weatherlookup.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.culler.weatherlookup.R
import com.culler.weatherlookup.model.WeatherInformation
import com.culler.weatherlookup.view.activity.WeatherDetailActivity
import com.culler.weatherlookup.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.row_item.view.*

class WeatherAdapter(
    val viewModel: WeatherViewModel,
    val arrayList: List<WeatherInformation>,
    val context: Context
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return WeatherViewHolder(root)
    }

    override
    fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override
    fun getItemCount(): Int {
        return arrayList.size
    }


    inner class WeatherViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: WeatherInformation) {
            val temp = String.format(context.getString(R.string.temp), weather.main.temperature.toString())
            itemView.txt_temparture.text = temp
            itemView.txt_weather.text = weather.weather[0].main
            itemView.layout_item.setOnClickListener {
                // navigate to next screen
                val intent = Intent(context, WeatherDetailActivity::class.java).apply {
                    putExtra("weather_item", arrayList.get(adapterPosition))
                }
                context.startActivity(intent)
            }
        }
    }
}