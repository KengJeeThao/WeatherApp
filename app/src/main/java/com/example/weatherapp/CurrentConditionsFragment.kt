package com.example.weatherapp

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.databinding.FragmentCurrentConiditionsBinding
import kotlinx.coroutines.currentCoroutineContext

class CurrentConditionsFragment : Fragment(R.layout.fragment_current_coniditions) {

    private lateinit var binding: FragmentCurrentConiditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCurrentConiditionsBinding.bind(view)
        binding.forecastButton.setOnClickListener {
            val forecast = Forecast(temp = "")
            val action = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToForecastFragment(forecast)
            findNavController().navigate(action)
            requireActivity().title = "Forecast"

        }
    }
}