package com.enterprise.userinterfaceelements.presentation.view.components.navigationbar

import androidx.compose.ui.graphics.vector.ImageVector
import com.enterprise.userinterfaceelements.R
import com.enterprise.userinterfaceelements.presentation.navigation.AppNavigationScreens


sealed class AppBottomNavigationBarItem(val route: AppNavigationScreens, val titleResourceId: Int, val iconResourceId: Int) {

    object AppImageItem: AppBottomNavigationBarItem(
        AppNavigationScreens.ImageScreenRoute,
        R.string.bottom_navigation_bar_item_image, R.drawable.baseline_person_24)

    object AppTextItem:
        AppBottomNavigationBarItem(AppNavigationScreens.TextScreenRoute,
            R.string.bottom_navigation_bar_item_text,R.drawable.baseline_home_24)

    object AppButtonItem:
        AppBottomNavigationBarItem(AppNavigationScreens.ButtonScreenRoute,
            R.string.bottom_navigation_bar_item_button, R.drawable.baseline_settings_24)

}