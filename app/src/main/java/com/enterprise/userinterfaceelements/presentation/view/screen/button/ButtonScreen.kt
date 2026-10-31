package com.enterprise.userinterfaceelements.presentation.view.screen.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.enterprise.userinterfaceelements.presentation.view.components.navigationbar.AppBottomNavigationBar


@Composable
fun ButtonScreen(backStack: NavBackStack<NavKey>) {

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { AppBottomNavigationBar(backStack = backStack) }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            Text("Button Screen")

        }
    }


}