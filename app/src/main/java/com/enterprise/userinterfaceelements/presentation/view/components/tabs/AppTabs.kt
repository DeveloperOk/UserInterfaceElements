package com.enterprise.userinterfaceelements.presentation.view.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppTabs() {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabs = listOf("Flights", "Trips", "Explore")

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PrimaryTabRow(
            modifier = Modifier.padding(horizontal = 10.dp),
            containerColor = Color.White,
            indicator = {
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(selectedTabIndex)
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(Color.Red)
                )
            },
            selectedTabIndex = selectedTabIndex
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                    },
                    modifier = Modifier.fillMaxSize().background(if(selectedTabIndex == index) Color.Cyan else Color.White),
                    text = {

                        Text(text = title)

                    }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> FlightsTabContent(title = "Flights Tab")
            1 -> TripsTabContent(title = "Trips Tab")
            2 -> ExploreTabContent(title = "Explore Tab")
        }
    }
}

@Composable
fun FlightsTabContent(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize().padding(5.dp).border(2.dp, Color.Green, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp
        )
    }
}

@Composable
fun TripsTabContent(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize().padding(5.dp).border(2.dp, Color.Blue, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp
        )
    }
}

@Composable
fun ExploreTabContent(title: String) {
    Box(
        modifier = Modifier
            .fillMaxSize().padding(5.dp).border(2.dp, Color.Cyan, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp
        )
    }
}
