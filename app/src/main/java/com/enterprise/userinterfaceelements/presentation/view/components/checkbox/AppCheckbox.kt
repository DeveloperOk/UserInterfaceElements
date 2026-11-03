package com.enterprise.userinterfaceelements.presentation.view.components.checkbox

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun AppCheckbox() {

    var checked by rememberSaveable { mutableStateOf(true) }

    Checkbox(
        colors = CheckboxDefaults.colors(checkedColor = Color.Green),
        checked = checked,
        onCheckedChange = { checked = it }
    )

}