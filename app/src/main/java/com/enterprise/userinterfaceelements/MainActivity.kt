package com.enterprise.userinterfaceelements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation3.runtime.rememberNavBackStack
import com.enterprise.userinterfaceelements.presentation.navigation.AppNavigationScreens
import com.enterprise.userinterfaceelements.presentation.view.components.modalnavigationdrawer.AppModalNavigationDrawer
import com.enterprise.userinterfaceelements.ui.theme.UserInterfaceElementsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFinisher = { this.finish()}

        enableEdgeToEdge()
        setContent {
            UserInterfaceElementsTheme {
                UserInterfaceElementsApp(activityFinisher = activityFinisher)
            }
        }
    }
}

@Composable
fun UserInterfaceElementsApp(activityFinisher: () -> Unit) {

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

    AppModalNavigationDrawer(backStack = backStack,
        scope = scope,
        drawerLocked = drawerLocked,
        drawerState = drawerState,
        activityFinisher = activityFinisher)

}







