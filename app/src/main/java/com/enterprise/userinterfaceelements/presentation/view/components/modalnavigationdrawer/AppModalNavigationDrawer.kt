package com.enterprise.userinterfaceelements.presentation.view.components.modalnavigationdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.enterprise.userinterfaceelements.R
import com.enterprise.userinterfaceelements.presentation.navigation.AppNavigation
import com.enterprise.userinterfaceelements.presentation.navigation.AppNavigationScreens
import com.enterprise.userinterfaceelements.presentation.navigation.navigateToScreenIfScreenIsNotAlreadyAtTop
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun AppModalNavigationDrawer(
    backStack: NavBackStack<NavKey>,
    scope: CoroutineScope,
    drawerLocked: MutableState<Boolean>,
    drawerState: DrawerState,
    activityFinisher: () -> Unit
) {

    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        gesturesEnabled = !drawerLocked.value,
        drawerContent = { DrawerOfModalNavigationDrawer(scope = scope, drawerState = drawerState, backStack = backStack) },
        content = { ContentOfModalNavigationDrawer(backStack = backStack, drawerLocked = drawerLocked, drawerState = drawerState,activityFinisher = activityFinisher) })

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

        AppDrawerItem(selected = AppNavigationScreens.DialogScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_dialog),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.DialogScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.LazyGridScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_lazy_grid),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.LazyGridScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.TextFieldScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_textfield),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.TextFieldScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.ImageScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_image),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.ImageScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.TextScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_text),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.TextScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.ButtonScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_button),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.ButtonScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.TopAppBarScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_top_app_bar),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.TopAppBarScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.LazyColumnScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_lazy_column),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.LazyColumnScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.PagerScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_pager),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.PagerScreenRoute)
                scope.launch { drawerState.close() }
            })

        Spacer(modifier = Modifier.height(5.dp))

        AppDrawerItem(selected = AppNavigationScreens.BadgedBoxScreenRoute == backStack.lastOrNull(),
            title = stringResource(id = R.string.drawer_item_badged_box),
            onClick = {
                navigateToScreenIfScreenIsNotAlreadyAtTop(backStack = backStack, route = AppNavigationScreens.BadgedBoxScreenRoute)
                scope.launch { drawerState.close() }
            })


    }
}

@Composable
fun AppDrawerItem(selected: Boolean,
                  title: String,
                  onClick: () -> Unit){

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(if(selected) Color.Green else Color.Yellow, RoundedCornerShape(5.dp))
            .border(2.dp, if(selected) Color.Blue else Color.Cyan, RoundedCornerShape(5.dp))
            .padding(5.dp)
            .clickable {
                onClick()
            }){

        Text(text = title, color = if(selected) Color.White else Color.Black)

    }

}


@Composable
fun ContentOfModalNavigationDrawer(
    backStack: NavBackStack<NavKey>,
    drawerLocked: MutableState<Boolean>,
    drawerState: DrawerState,
    activityFinisher: () -> Unit
) {

    AppNavigation(backStack = backStack, drawerLocked = drawerLocked, drawerState = drawerState,activityFinisher = activityFinisher)

}

