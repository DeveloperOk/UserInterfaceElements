package com.enterprise.userinterfaceelements.presentation.view.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.enterprise.userinterfaceelements.R


@Composable
fun AppImage(){

    Image(painter = painterResource(R.drawable.landscape),
        contentDescription = "Landscape",
        modifier = Modifier.fillMaxWidth(0.5f)
            .clip(RoundedCornerShape(15.dp, 0.dp, 15.dp, 0.dp)))

}