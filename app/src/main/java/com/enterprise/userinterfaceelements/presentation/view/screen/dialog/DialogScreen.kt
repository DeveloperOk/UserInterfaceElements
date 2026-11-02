package com.enterprise.userinterfaceelements.presentation.view.screen.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.enterprise.userinterfaceelements.R
import com.enterprise.userinterfaceelements.presentation.view.components.dialog.AppExitDialog


@Composable
fun DialogScreen(activityFinisher: () -> Unit) {

    var isDialogVisible = rememberSaveable { mutableStateOf(false) }

    if(isDialogVisible.value){

        AppExitDialog(isDialogVisible = isDialogVisible,
            activityFinisher = activityFinisher)

    }

    Scaffold(modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                onClick = {

                    isDialogVisible.value = true

                }) {

                Text(text = stringResource(id = R.string.show_exit_dialog))

            }

        }
    }


}