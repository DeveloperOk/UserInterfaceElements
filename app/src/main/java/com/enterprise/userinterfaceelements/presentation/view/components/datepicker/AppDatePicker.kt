package com.enterprise.userinterfaceelements.presentation.view.components.datepicker

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun AppDatePicker(){

    val isDatePickerVisible = rememberSaveable { mutableStateOf(false) }
    val selectedDate = rememberSaveable { mutableStateOf("Pick Date") }

    Column(modifier = Modifier.width(120.dp)
        .border(2.dp, Color.Green, RoundedCornerShape(10.dp))
        .padding(4.dp)
        .clickable{
            isDatePickerVisible.value = true
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text = selectedDate.value)

    }

    if(isDatePickerVisible.value){
        AppDatePickerModal(
            onDateSelected = { selectedDateMillis ->

                selectedDateMillis?.let { selectedDate.value = convertMillisToDate(it) }

                isDatePickerVisible.value = false

            },
            onDismiss = {
                isDatePickerVisible.value = false
            })
    }

}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}


@Composable
fun AppDatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}