package com.enterprise.userinterfaceelements.presentation.view.components.androidview

import android.widget.TextView
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.enterprise.userinterfaceelements.R


@Composable
fun AppAndroidView(){


    AndroidView(
        modifier = Modifier.wrapContentWidth().wrapContentHeight().padding(5.dp),
        factory = { context ->
            // Creates view
            TextView(context).apply {

                text = context.getString(R.string.android_view_screen_textview_text)
                textSize = 20F
                setTextColor(context.getColor(R.color.teal_200))

            }
        },
        update = { view ->
            // View's been inflated or state read in this block has been updated
            // Add logic here if necessary

            // As selectedItem is read here, AndroidView will recompose
            // whenever the state changes
            // Example of Compose -> View communication
            //view.text = textOfTextView.value

        }
    )


}

