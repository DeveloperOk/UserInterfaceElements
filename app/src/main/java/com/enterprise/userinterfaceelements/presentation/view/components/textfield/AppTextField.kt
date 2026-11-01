package com.enterprise.userinterfaceelements.presentation.view.components.textfield

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun AppTextField(){

    val inputValue = rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    Text(text = inputValue.value.text, modifier = Modifier.padding(5.dp))

    Spacer(modifier = Modifier.height(5.dp))

    OutlinedTextField(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        value = inputValue.value,
        onValueChange = {
            inputValue.value = it
        },
        label = {
            Text(text = "Input Value")
        }

    )


}