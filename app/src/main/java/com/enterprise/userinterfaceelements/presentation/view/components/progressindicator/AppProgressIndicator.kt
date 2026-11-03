package com.enterprise.userinterfaceelements.presentation.view.components.progressindicator

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun AppCircularProgressIndicator() {

    CircularProgressIndicator(color = Color.Green)

}

@Composable
fun AppLinearProgressIndicator() {

    LinearProgressIndicator(color = Color.Green)

}
