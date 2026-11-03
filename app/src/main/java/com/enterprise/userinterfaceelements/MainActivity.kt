package com.enterprise.userinterfaceelements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
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

    AppModalNavigationDrawer(activityFinisher = activityFinisher)

}







