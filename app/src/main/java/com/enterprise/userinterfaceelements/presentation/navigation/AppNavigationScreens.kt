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

    @Serializable
    object PagerScreenRoute : AppNavigationScreens

    @Serializable
    object TextFieldScreenRoute : AppNavigationScreens

    @Serializable
    object DialogScreenRoute : AppNavigationScreens

    @Serializable
    object LazyGridScreenRoute : AppNavigationScreens

    @Serializable
    object BadgedBoxScreenRoute : AppNavigationScreens

    @Serializable
    object TabsScreenRoute : AppNavigationScreens

    @Serializable
    object ConstraintLayoutScreenRoute : AppNavigationScreens

    @Serializable
    object CanvasScreenRoute : AppNavigationScreens

    @Serializable
    object AndroidViewScreenRoute : AppNavigationScreens

    @Serializable
    object ProgressIndicatorScreenRoute : AppNavigationScreens

    @Serializable
    object VariousElementsScreenRoute : AppNavigationScreens

    @Serializable
    object SnackbarScreenRoute : AppNavigationScreens


}