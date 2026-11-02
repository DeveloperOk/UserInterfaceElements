package com.enterprise.userinterfaceelements.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.enterprise.userinterfaceelements.presentation.view.screen.button.ButtonScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.dialog.DialogScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.image.ImageScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.lazycolumn.LazyColumnScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.lazygrid.LazyGridScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.pager.PagerScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.splash.SplashScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.text.TextScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.textfield.TextFieldScreen
import com.enterprise.userinterfaceelements.presentation.view.screen.topappbar.TopAppBarScreen


@Composable
fun AppNavigation(
    backStack: NavBackStack<NavKey>,
    drawerLocked: MutableState<Boolean>,
    drawerState: DrawerState,
    activityFinisher: () -> Unit
) {

    NavDisplay(
        backStack = backStack,

        onBack = { backStack.removeLastOrNull() },

        //In order to clear viewmodel, on navigation back
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),

        entryProvider = entryProvider {

            entry<AppNavigationScreens.SplashScreenRoute> {
                SplashScreen(drawerLocked = drawerLocked, navigateToMainScreen = {

                    navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.TextScreenRoute)
                    backStack.removeAt(0)

                })
            }

            entry<AppNavigationScreens.ImageScreenRoute> {
                ImageScreen(backStack = backStack)
            }

            entry<AppNavigationScreens.TextScreenRoute> {
                TextScreen(backStack = backStack, drawerState = drawerState,)
            }

            entry<AppNavigationScreens.ButtonScreenRoute> {
                ButtonScreen(backStack = backStack)
            }

            entry<AppNavigationScreens.TopAppBarScreenRoute> {
                TopAppBarScreen(backStack = backStack)
            }

            entry<AppNavigationScreens.LazyColumnScreenRoute> {
                LazyColumnScreen()
            }

            entry<AppNavigationScreens.PagerScreenRoute> {
                PagerScreen()
            }

            entry<AppNavigationScreens.TextFieldScreenRoute> {
                TextFieldScreen()
            }

            entry<AppNavigationScreens.DialogScreenRoute> {
                DialogScreen(activityFinisher = activityFinisher)
            }

            entry<AppNavigationScreens.LazyGridScreenRoute> {
                LazyGridScreen()
            }

        }

    )

}

fun navigateToScreenIfScreenIsNotAlreadyAtTop(
    backStack: NavBackStack<NavKey>,
    route: AppNavigationScreens
) {

    if(backStack.lastOrNull() == null){

        backStack.add(route)

    }else if(backStack.lastOrNull()!!::class != route::class){

        backStack.add(route)

    }

}