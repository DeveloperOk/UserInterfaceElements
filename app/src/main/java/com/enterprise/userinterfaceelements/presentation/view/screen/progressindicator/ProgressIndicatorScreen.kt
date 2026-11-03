package com.enterprise.userinterfaceelements.presentation.view.screen.progressindicator

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
import com.enterprise.userinterfaceelements.presentation.view.components.progressindicator.AppCircularProgressIndicator
import com.enterprise.userinterfaceelements.presentation.view.components.progressindicator.AppLinearProgressIndicator


@Composable
fun ProgressIndicatorScreen() {

    Scaffold(modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            Text(text = "Circular Progress Indicator")
            AppCircularProgressIndicator()

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Linear Progress Indicator")
            AppLinearProgressIndicator()

        }
    }


}