package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditionsScreen(
    cityName: String,
    temperature: String,
)  {

    Scaffold(

    ) {

        CurrentConditionsContent(cityName = cityName, temperature = temperature)
        
        ForecastCondition(
            temp = "72",
            tempHigh = "80",
            tempLow = "60",
            sunRise = "Sunrise 8:00am",
            sunSet = "Sunset 9:00pm",
        )
    }
}

@Composable
private fun CurrentConditionsContent(
    cityName: String,
    temperature: String,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = cityName,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(text = temperature,
                style = TextStyle(fontSize = 72.sp,
                    fontWeight = FontWeight(600),
                )

            )
            Spacer(modifier = Modifier.weight(1.0f, fill = true))
            Image(
                modifier = Modifier
                    .size(72.dp),

                painter = painterResource(id = R.drawable.sun),
                contentDescription = "Sunny",
            )

        }

        Text(
            modifier = Modifier
                .absoluteOffset((-140).dp)
                .padding(vertical = 10.dp),
            text = "Feels like 78°",
            style = TextStyle(
                fontSize = 11.sp,
                fontWeight = FontWeight(400)
            )
        )

        Text(
            modifier = Modifier
                .absoluteOffset((-140).dp),
            text = "Low 65°",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )

        Text(
            modifier = Modifier
                .absoluteOffset((-140).dp),
            text = "High 80°",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )

        Text(
            modifier = Modifier
                .absoluteOffset((-114).dp),
            text = "Humidity 100%",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )

        Text(
            modifier = Modifier
                .absoluteOffset((-101).dp),
            text = "Pressure 1023hPa",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )

        Text(
            modifier = Modifier
                .padding(vertical = 100.dp),
            text = "",
        )


        Button(onClick = {
            /*TODO*/
        }) {
            Text(
                text = "Forecast",
            )
        }

    }
}


@Composable
private fun ForecastCondition(
    temp: String,
    tempHigh: String,
    tempLow: String,
    sunRise: String,
    sunSet: String,

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = temp,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400)
            )
        )
    }
}


@Preview(
    "CurrentConditions",
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun CurrentConditionsScreenPreview(){
    CurrentConditionsScreen(
        cityName = "St. Paul, MN",
        temperature = "72°",
    )
}
