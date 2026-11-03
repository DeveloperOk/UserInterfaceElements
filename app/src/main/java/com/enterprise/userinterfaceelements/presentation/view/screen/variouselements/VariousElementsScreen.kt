package com.enterprise.userinterfaceelements.presentation.view.screen.variouselements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.enterprise.userinterfaceelements.presentation.view.components.appswitch.AppSwitch
import com.enterprise.userinterfaceelements.presentation.view.components.checkbox.AppCheckbox
import com.enterprise.userinterfaceelements.presentation.view.components.slider.AppSlider


@Composable
fun VariousElementsScreen() {

    Scaffold(modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            Text(text = "Checkbox")
            AppCheckbox()

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "Switch")
            AppSwitch()

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "Slider")
            AppSlider()

        }
    }


}