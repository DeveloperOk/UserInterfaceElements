package com.enterprise.userinterfaceelements.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface AppNavigationScreens: NavKey {

    // Define a main screen route that doesn't take any arguments
    @Serializable
    object MainScreenRoute : AppNavigationScreens
    
    @Serializable
    object SideScreenRoute : AppNavigationScreens


}