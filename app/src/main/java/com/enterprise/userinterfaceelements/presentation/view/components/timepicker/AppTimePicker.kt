package com.enterprise.userinterfaceelements.presentation.view.components.timepicker

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Calendar


@Composable
fun AppTimePicker(){

    val isTimePickerVisible = rememberSaveable { mutableStateOf(false) }
    val selectedTime = rememberSaveable { mutableStateOf("Pick Time") }

    Column(modifier = Modifier.width(120.dp)
        .border(2.dp, Color.Green, RoundedCornerShape(10.dp))
        .padding(4.dp)
        .clickable{
            isTimePickerVisible.value = true
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text = selectedTime.value)

    }

    if(isTimePickerVisible.value){

        AppDialTimePicker(
            onConfirm = { hour, minute ->

                selectedTime.value =
                    "${formatTwoDigits(hour)}:${formatTwoDigits(minute)}"

                isTimePickerVisible.value = false

            },
            onDismiss = {

                isTimePickerVisible.value = false

            },
        )
    }

}

fun formatTwoDigits(inputNumber: Int):String{

    val inputString = inputNumber.toString()
    var outputString = inputString

    if(inputString.length == 1){

        outputString = "0$inputString"

    }

    return outputString
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDialTimePicker(
    onConfirm: (hour: Int, minute: Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    BasicAlertDialog(onDismissRequest = {
        // Dismiss the dialog when the user clicks outside the dialog or on the back button.
        //isDialogVisible.value = false
    }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.wrapContentSize().
            background(Color.White, RoundedCornerShape(15.dp)).
            padding(10.dp)
        ) {
            TimePicker(
                state = timePickerState,
            )

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                onClick = {
                    onConfirm(
                        timePickerState.hour,
                        timePickerState.minute
                    )
                }) {
                Text("Confirm selection")
            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                onClick = onDismiss
            ) {
                Text("Dismiss picker")
            }

        }
    }
}