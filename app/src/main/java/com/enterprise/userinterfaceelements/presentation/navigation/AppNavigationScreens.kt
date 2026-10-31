package com.enterprise.userinterfaceelements.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface AppNavigationScreens: NavKey {


    @Serializable
    object SplashScreenRoute : AppNavigationScreens

    @Serializable
    object TextScreenRoute : AppNavigationScreens

    @Serializable
    object ImageScreenRoute : AppNavigationScreens

    @Serializable
    object ButtonScreenRoute : AppNavigationScreens

    @Serializable
    object TopAppBarScreenRoute : AppNavigationScreens

    @Serializable
    object LazyColumnScreenRoute : AppNavigationScreens

    object PagerScreenRoute : AppNavigationScreens

}