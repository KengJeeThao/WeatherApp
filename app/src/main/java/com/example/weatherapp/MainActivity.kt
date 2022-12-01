package com.example.weatherapp

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.models.LatitudeLongitude
import android.content.pm.PackageManager
import com.google.android.gms.location.LocationServices
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.weatherapp.ui.ForecastConditions
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Priority


class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var latitudeLongitude: LatitudeLongitude? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called")
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentConditions") {
                composable("CurrentConditions") {
                    val onResult = {value: Boolean ->
                        if(ActivityCompat.checkSelfPermission(this@MainActivity, ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                            fusedLocationProviderClient
                                .getCurrentLocation(Priority.PRIORITY_BALANCED_POWER_ACCURACY, null)
                                .addOnSuccessListener { location ->
                                    latitudeLongitude = LatitudeLongitude(
                                        latitude = location.latitude.toFloat(),
                                        longitude = location.longitude.toFloat()
                                    )
                                }
                        }
                    }
                        val requestPermissionLauncher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.RequestPermission(),
                            onResult = onResult
                        )

                    CurrentConditions(
                        latitudeLongitude = latitudeLongitude,
                        onMyLocationButtonClick = {
                            requestPermissionLauncher.launch(ACCESS_COARSE_LOCATION)
                        },
                        onForecastButtonClick = { navController.navigate("Forecast") }
                    )
                }
                composable("Forecast") {
                    ForecastConditions(latitudeLongitude)
                    ForecastConditions(
                        latitudeLongitude = latitudeLongitude
                    )
                }
            }
        }
    }

    private fun CurrentConditions(
        onForecastButtonClick: () -> Unit,
        onMyLocationButtonClick: Any,
        latitudeLongitude: LatitudeLongitude?
    ) {

    }


    companion object {
        private const val TAG = "MainActivity"
    }

}

