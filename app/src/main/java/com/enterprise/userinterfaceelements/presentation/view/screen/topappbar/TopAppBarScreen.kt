package com.enterprise.userinterfaceelements.presentation.view.screen.topappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.enterprise.userinterfaceelements.R
import com.enterprise.userinterfaceelements.presentation.view.components.topappbar.AppTopAppBar
import kotlinx.coroutines.launch

@Composable
fun TopAppBarScreen(backStack: NavBackStack<NavKey>) {

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBarScreenTopAppBar(backStack = backStack) }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {


        }
    }

}

@Composable
fun TopAppBarScreenTopAppBar(backStack: NavBackStack<NavKey>) {

    AppTopAppBar(title = {
        Text(text = stringResource(R.string.top_app_bar_screen_app_top_app_bar_title),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)},
        navigationIcon = {
            IconButton(onClick = {
                backStack.removeLastOrNull()
            }){ Icon(painter = painterResource(R.drawable.baseline_arrow_back_24), contentDescription = "Arrow Back") } },
        modifier = Modifier.fillMaxWidth()/*.systemBarsPadding()*/)

}