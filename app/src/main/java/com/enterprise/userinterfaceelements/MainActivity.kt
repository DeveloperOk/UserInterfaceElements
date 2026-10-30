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
import androidx.compose.runtime.rememberCoroutineScope
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
        AppNavigationScreens.MainScreenRoute
    )

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
         modifier = Modifier.fillMaxSize(),
         drawerState = drawerState,
         drawerContent = { DrawerOfModalNavigationDrawer(scope = scope, drawerState = drawerState, backStack = backStack) },
         content = { ContentOfModalNavigationDrawer(backStack = backStack) })

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
            .width(200.dp)
            .systemBarsPadding()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ){

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    backStack.add(AppNavigationScreens.MainScreenRoute)
                    scope.launch { drawerState.close() }
                }){

            Text(text = stringResource(id = R.string.drawer_item_text_main))

        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    backStack.add(AppNavigationScreens.SideScreenRoute)
                    scope.launch { drawerState.close() }
                }){

            Text(text = stringResource(id = R.string.drawer_item_text_side))

        }


    }
}


@Composable
fun ContentOfModalNavigationDrawer(backStack: NavBackStack<NavKey>) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            AppNavigation(backStack = backStack)

        }
    }
}



