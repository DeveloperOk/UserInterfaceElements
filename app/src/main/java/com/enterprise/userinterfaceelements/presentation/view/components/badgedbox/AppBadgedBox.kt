package com.enterprise.userinterfaceelements.presentation.view.components.badgedbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enterprise.userinterfaceelements.R

@Composable
fun AppBadgedBox(){

    BadgedBox(

        badge = {

            Column(modifier = Modifier.width(25.dp).height(25.dp).clip(RoundedCornerShape(5.dp))
                .border(2.dp, Color.Red, RoundedCornerShape(5.dp))
                .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = "3", color = Color.Black)

            }

        },
        modifier = Modifier

    ) {

        Image(painter = painterResource(R.drawable.baseline_notifications_100),
            contentDescription = "Notifications",
            modifier = Modifier.border(2.dp, Color.Green, RoundedCornerShape(5.dp)))



    }


}

