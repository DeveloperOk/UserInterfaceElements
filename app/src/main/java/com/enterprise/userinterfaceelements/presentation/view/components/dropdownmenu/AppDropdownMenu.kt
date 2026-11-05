package com.enterprise.userinterfaceelements.presentation.view.components.dropdownmenu

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppDropdownMenu() {

    var expanded by rememberSaveable { mutableStateOf(false) }
    val items = arrayListOf<String>("Option 1", "Option 2")
    val selectedItem = rememberSaveable { mutableStateOf("Click to Select an Option") }

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {

        Column(modifier = Modifier.width(250.dp)
            .border(2.dp, Color.Green, RoundedCornerShape(10.dp))
            .padding(4.dp)
            .clickable{
                expanded = !expanded
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Text(text = selectedItem.value)

        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            items.forEach { item ->

                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {

                        selectedItem.value = item
                        expanded = false

                    }
                )

            }

        }
    }
}