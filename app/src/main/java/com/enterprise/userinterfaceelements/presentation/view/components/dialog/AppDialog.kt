package com.enterprise.userinterfaceelements.presentation.view.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.enterprise.userinterfaceelements.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppExitDialog(isDialogVisible: MutableState<Boolean>, activityFinisher: () -> Unit) {

    BasicAlertDialog(onDismissRequest = {
        // Dismiss the dialog when the user clicks outside the dialog or on the back button.
        //isDialogVisible.value = false
    }){

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.wrapContentHeight()
                .wrapContentWidth().
                background(color = Color.White, RoundedCornerShape(size = 15.dp))
                .padding(15.dp)){

            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().wrapContentHeight()){

                Icon(painter = painterResource(R.drawable.baseline_info_24),
                    contentDescription
                    = stringResource(id = R.string.dialog_title_icon_content_description),
                    tint = Color.Blue)

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = stringResource(id = R.string.dialog_title))


            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = stringResource(id = R.string.dialog_message))

            Spacer(modifier = Modifier.height(15.dp))

            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().wrapContentHeight()){

                Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                    modifier = Modifier.weight(1F),
                    onClick = {

                        isDialogVisible.value = false

                        activityFinisher()

                    }) {

                    Text(text = stringResource(id = R.string.dialog_positive_button_text))

                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.weight(1F),
                    onClick = {

                        isDialogVisible.value = false

                    }) {

                    Text(text = stringResource(id = R.string.dialog_negative_button_text))

                }

            }

        }

    }

}