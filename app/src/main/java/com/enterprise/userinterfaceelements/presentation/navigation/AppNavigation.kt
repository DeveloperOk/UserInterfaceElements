package com.enterprise.userinterfaceelements.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.enterprise.userinterfaceelements.presentation.view.screen.main.MainScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.side.SideScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.splash.SplashScreen


@Composable
fun AppNavigation(backStack: NavBackStack<NavKey>, drawerLocked: MutableState<Boolean>) {

    NavDisplay(
        backStack = backStack,

        onBack = { backStack.removeLastOrNull() },

        //In order to clear viewmodel, on navigation back
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),

        entryProvider = entryProvider {

            entry<AppNavigationScreens.MainScreenRoute> {
                MainScreen()
            }

            entry<AppNavigationScreens.SideScreenRoute> {
                SideScreen()
            }

            entry<AppNavigationScreens.SplashScreenRoute> {
                SplashScreen(drawerLocked = drawerLocked, navigateToMainScreen = {

                    backStack.add(AppNavigationScreens.MainScreenRoute)
                    backStack.removeAt(0)

                })
            }

        }

    )

}