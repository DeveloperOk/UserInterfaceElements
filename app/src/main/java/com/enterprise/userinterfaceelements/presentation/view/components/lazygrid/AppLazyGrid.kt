package com.enterprise.userinterfaceelements.presentation.view.components.lazygrid

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AppLazyGrid(){

    val itemList = (1..100).map { "Item $it" }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()){

        items(itemList){ inputItem ->

            LazyGridItem(item = inputItem)

        }

    }

}


@Composable
fun LazyGridItem(item : String){

    val context = LocalContext.current

    Surface(
        modifier = Modifier.padding(5.dp).fillMaxWidth(0.5F)
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
        border = BorderStroke(2.dp, Color.Green)
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
