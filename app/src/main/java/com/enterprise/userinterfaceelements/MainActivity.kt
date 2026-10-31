package com.enterprise.userinterfaceelements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.enterprise.userinterfaceelements.presentation.navigation.AppNavigation
import com.enterprise.userinterfaceelements.presentation.navigation.AppNavigationScreens
import com.enterprise.userinterfaceelements.ui.theme.UserInterfaceElementsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserInterfaceElementsTheme {
                UserInterfaceElementsApp()
            }
        }
    }
}

@Composable
fun UserInterfaceElementsApp() {

    //With rememberNavBackStack, backstack survives the configuration changes such as screen rotation etc.
    val backStack = rememberNavBackStack(
        //NavigationStartScreen
        AppNavigationScreens.SplashScreenRoute
    )

    val scope = rememberCoroutineScope()
    val drawerLocked = rememberSaveable { mutableStateOf(false) }

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed,
        confirmStateChange = { newValue ->
            !drawerLocked.value || newValue == DrawerValue.Closed
        }
    )

    ModalNavigationDrawer(
         modifier = Modifier.fillMaxSize(),
         drawerState = drawerState,
         gesturesEnabled = !drawerLocked.value,
         drawerContent = { DrawerOfModalNavigationDrawer(scope = scope, drawerState = drawerState, backStack = backStack) },
         content = { ContentOfModalNavigationDrawer(backStack = backStack, drawerLocked = drawerLocked) })

}

@Composable
fun DrawerOfModalNavigationDrawer(
    scope: CoroutineScope,
    drawerState: DrawerState,
    backStack: NavBackStack<NavKey>
) {


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxHeight()
            .width(280.dp)
            .systemBarsPadding()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ){

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    backStack.add(AppNavigationScreens.ImageScreenRoute)
                    scope.launch { drawerState.close() }
                }){

            Text(text = stringResource(id = R.string.drawer_item_text_image))

        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    backStack.add(AppNavigationScreens.TextScreenRoute)
                    scope.launch { drawerState.close() }
                }){

            Text(text = stringResource(id = R.string.drawer_item_text_text))

        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    backStack.add(AppNavigationScreens.ButtonScreenRoute)
                    scope.launch { drawerState.close() }
                }){

            Text(text = stringResource(id = R.string.drawer_item_text_button))

        }

    }
}


@Composable
fun ContentOfModalNavigationDrawer(
    backStack: NavBackStack<NavKey>,
    drawerLocked: MutableState<Boolean>
) {

    AppNavigation(backStack = backStack, drawerLocked = drawerLocked)

}



