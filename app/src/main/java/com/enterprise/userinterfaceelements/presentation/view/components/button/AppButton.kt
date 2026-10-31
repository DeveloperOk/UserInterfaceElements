package com.enterprise.userinterfaceelements.presentation.view.components.button

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@Composable
fun AppFilledButton() {
    val context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, "Filled Button is clicked.", Toast.LENGTH_SHORT).show()
    }) {
        Text("Filled")
    }
}

@Composable
fun AppFilledTonalButton() {

    val context = LocalContext.current

    FilledTonalButton(onClick = {
        Toast.makeText(context, "Filled Tonal Button is clicked.", Toast.LENGTH_SHORT).show()
    }) {
        Text("Tonal")
    }

}


@Composable
fun AppOutlinedButton() {

    val context = LocalContext.current

    OutlinedButton(onClick = {
        Toast.makeText(context, "Outlined Button is clicked.", Toast.LENGTH_SHORT).show()
    }) {
        Text("Outlined")
    }

}

@Composable
fun AppElevatedButton() {

    val context = LocalContext.current

    ElevatedButton(onClick = {
        Toast.makeText(context, "Elevated Button is clicked.", Toast.LENGTH_SHORT).show()
    }) {
        Text("Elevated")
    }

}

@Composable
fun AppTextButton() {

    val context = LocalContext.current

    TextButton(
        onClick = {
            Toast.makeText(context, "Text Button is clicked.", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text("Text Button")
    }
}