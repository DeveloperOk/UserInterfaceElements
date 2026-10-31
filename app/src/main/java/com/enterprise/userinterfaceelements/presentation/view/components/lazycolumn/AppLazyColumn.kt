package com.enterprise.userinterfaceelements.presentation.view.components.lazycolumn

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun AppLazyColumn(){

    val itemList = (1..100).map { "Item $it" }

    LazyColumn {

        items(itemList){ inputItem ->

            LazyColumnRow(item = inputItem)

        }

    }

}



@Composable
fun LazyColumnRow(item : String){

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxWidth(0.8F).padding(10.dp)
            .clickable {
                Toast.makeText(context, item, Toast.LENGTH_SHORT)
                    .show()
            },
        shadowElevation = 20.dp,
        shape = RoundedCornerShape(
            topStart = 15.dp,
            topEnd = 0.dp,
            bottomEnd = 15.dp,
            bottomStart = 0.dp
        ),
        border = BorderStroke(2.dp, Color.Green,)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {

            Text(text = item)

        }

    }

}