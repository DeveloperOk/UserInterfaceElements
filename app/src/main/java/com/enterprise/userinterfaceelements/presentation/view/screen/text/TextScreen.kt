package com.enterprise.userinterfaceelements.presentation.view.screen.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.enterprise.userinterfaceelements.presentation.view.components.navigationbar.AppBottomNavigationBar
import com.enterprise.userinterfaceelements.presentation.view.components.text.AnnotatedText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppClickablePartsText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppCustomFontText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppOverflowText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppSimpleText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppWrapText


@Composable
fun TextScreen(backStack: NavBackStack<NavKey>) {

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { AppBottomNavigationBar(backStack = backStack) }
        ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(10.dp)
        ) {

            AppSimpleText()

            Spacer(modifier = Modifier.height(10.dp))

            AppWrapText()

            Spacer(modifier = Modifier.height(10.dp))

            AppOverflowText()

            Spacer(modifier = Modifier.height(10.dp))

            AnnotatedText()

            Spacer(modifier = Modifier.height(10.dp))

            AppClickablePartsText()

            Spacer(modifier = Modifier.height(10.dp))

            AppCustomFontText()

        }
    }


}