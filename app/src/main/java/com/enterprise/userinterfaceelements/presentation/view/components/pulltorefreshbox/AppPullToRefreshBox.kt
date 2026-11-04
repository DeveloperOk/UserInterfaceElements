package com.enterprise.userinterfaceelements.presentation.view.components.pulltorefreshbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds


@Composable
fun AppPullToRefreshBox() {

    val isRefreshing = rememberSaveable { mutableStateOf(false)}
    val refreshCounter = rememberSaveable { mutableStateOf(0)}

    val scope = rememberCoroutineScope()

    PullToRefreshBox(
        isRefreshing = isRefreshing.value,
        onRefresh = {
            scope.launch(Dispatchers.Main) {

                isRefreshing.value = true

                //Simulate refreshing action
                delay(3.seconds)
                refreshCounter.value = refreshCounter.value + 1

                isRefreshing.value = false

            }
        },
        modifier = Modifier
    ) {


        //To make PullToRefreshBox work, content must be scrollable
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ){

            Text("To Refresh: Pull From Top to Bottom")

            Text("Refresh Counter: ${refreshCounter.value}")

        }

    }
}