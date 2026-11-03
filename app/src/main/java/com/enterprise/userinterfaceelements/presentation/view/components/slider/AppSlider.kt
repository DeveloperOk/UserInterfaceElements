package com.enterprise.userinterfaceelements.presentation.view.components.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun AppSlider() {

    var sliderPosition by rememberSaveable { mutableFloatStateOf(0.5f) }

    Column {

        Slider(modifier = Modifier.fillMaxWidth(0.75f),
            colors = SliderDefaults.colors(activeTrackColor = Color.Green),
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )

        Text(text = sliderPosition.toString())

    }
}