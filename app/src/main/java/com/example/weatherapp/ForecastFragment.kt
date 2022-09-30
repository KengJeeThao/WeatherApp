package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.FragmentForecastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

private val forecastData = listOf(
    Forecast("Jan 26"),
    Forecast("Jan 27"),
    Forecast("Jan 28"),
    Forecast("Jan 29"),
    Forecast("Jan 30"),
    Forecast("Jan 31"),
    Forecast("Feb 1"),
    Forecast("Feb 2"),
    Forecast("Feb 3"),
    Forecast("Feb 4"),
    Forecast("Feb 5"),
    Forecast("Feb 6"),
    Forecast("Feb 7"),
    Forecast("Feb 8"),
    Forecast("Feb 9"),
    Forecast("Feb 10"),
)


class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastTemp.text = args.forecast.temp
        binding.forecastList.adapter = ForecastAdapter(forecastData)


        val dateTimeStamp = 1663199913L
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val formattedTime = timeFormatter.format(dateTime)

        val tempString = resources.getString(R.string.degree_symbol, 70)

        Log.d("ForecastFragment", formattedDate)
        Log.d("ForecastFragment", formattedTime)


    }
}

