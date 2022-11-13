package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import com.example.weatherapp.ui.CurrentConditionsScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called")
        setContentView(R.layout.activity_main)


        setContent{
            CurrentConditionsScreen(
                cityName = stringResource(id = R.string.city_name),
                temperature = stringResource(id = R.string.current_temp, 56),
            )

        }


    }



    companion object {
        private const val TAG = "MainActivity"
    }

}

