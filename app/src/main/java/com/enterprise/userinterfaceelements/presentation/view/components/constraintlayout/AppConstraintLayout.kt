package com.enterprise.userinterfaceelements.presentation.view.components.constraintlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.enterprise.userinterfaceelements.R


@Composable
fun AppConstraintLayout(){

    ConstraintLayout(modifier = Modifier
        .padding(4.dp)) {

        val (notificationImage, appBadge) = createRefs()

        NotificationImage(modifier = Modifier.constrainAs(notificationImage) {
            top.linkTo(parent.top, margin = 0.dp)
            start.linkTo(parent.start, margin = 0.dp)
            end.linkTo(parent.end, margin = 0.dp)
            bottom.linkTo(parent.bottom, margin = 0.dp)
        })

        AppBadge(modifier = Modifier.constrainAs(appBadge) {
            top.linkTo(parent.top, margin = 20.dp)
            end.linkTo(parent.end, margin = 20.dp)

        })


    }

}

@Composable
fun NotificationImage(modifier: Modifier){

    Image(painter = painterResource(R.drawable.baseline_notifications_100),
        contentDescription = "Notifications",
        modifier = modifier.border(2.dp, Color.Green, RoundedCornerShape(5.dp)))

}

@Composable
fun AppBadge(modifier: Modifier){

    Column(modifier = modifier.width(25.dp).height(25.dp).clip(CircleShape)
        .background(Color.Red, CircleShape),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "3", color = Color.White)
    }

}
