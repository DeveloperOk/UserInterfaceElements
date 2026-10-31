package com.enterprise.userinterfaceelements.presentation.view.components.navigationbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey


@Composable
fun AppBottomNavigationBar(
    backStack: NavBackStack<NavKey>
){

    //1- The Items of Bottom Nav Bar
    val navItems = listOf(AppBottomNavigationBarItem.AppImageItem, AppBottomNavigationBarItem.AppTextItem, AppBottomNavigationBarItem.AppButtonItem)

    NavigationBar {
        navItems.forEachIndexed { index, item ->

            NavigationBarItem(
                selected = item.route == backStack.lastOrNull(),
                onClick = {
                    backStack.add(item.route)
                },
                icon = { Icon(painter = painterResource(item.iconResourceId),
                    contentDescription = stringResource( item.titleResourceId)) },

                label = { Text(stringResource( item.titleResourceId))}

            )

        }
    }

}
