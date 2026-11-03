package com.enterprise.userinterfaceelements.presentation.view.components.appswitch

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


@Composable
fun AppSwitch() {

    var checked by rememberSaveable { mutableStateOf(true) }

    Switch(colors = SwitchDefaults.colors(checkedTrackColor = Color.Green),
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )

}