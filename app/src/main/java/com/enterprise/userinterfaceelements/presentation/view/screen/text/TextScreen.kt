package com.enterprise.userinterfaceelements.presentation.view.screen.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DrawerState
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
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.enterprise.userinterfaceelements.R
import com.enterprise.userinterfaceelements.presentation.view.components.navigationbar.AppBottomNavigationBar
import com.enterprise.userinterfaceelements.presentation.view.components.text.AnnotatedText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppClickablePartsText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppCustomFontText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppOverflowText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppSimpleText
import com.enterprise.userinterfaceelements.presentation.view.components.text.AppWrapText
import com.enterprise.userinterfaceelements.presentation.view.components.topappbar.AppTopAppBar
import kotlinx.coroutines.launch


@Composable
fun TextScreen(backStack: NavBackStack<NavKey>, drawerState: DrawerState) {


    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TextScreenTopAppBar(drawerState = drawerState) },
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

@Composable
fun TextScreenTopAppBar(drawerState: DrawerState) {

    val scope = rememberCoroutineScope()

    AppTopAppBar(title = {
        Text(text = stringResource(R.string.text_screen_app_top_app_bar_title),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)},
        navigationIcon = {
            IconButton(onClick = {
                scope.launch { drawerState.open() }
            }){ Icon(painter = painterResource(R.drawable.baseline_menu_24), contentDescription = "Menu") } },
        modifier = Modifier.fillMaxWidth()/*.systemBarsPadding()*/)

}