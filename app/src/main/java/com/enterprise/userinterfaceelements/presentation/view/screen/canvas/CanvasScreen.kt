package com.enterprise.userinterfaceelements.presentation.view.screen.canvas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.enterprise.userinterfaceelements.domain.constants.allColors
import com.enterprise.userinterfaceelements.domain.`interface`.DrawingAction
import com.enterprise.userinterfaceelements.presentation.view.components.canvas.AppCanvasControls
import com.enterprise.userinterfaceelements.presentation.view.components.canvas.AppDrawingCanvas
import com.enterprise.userinterfaceelements.presentation.viewmodel.DrawingViewModel


@Composable
fun CanvasScreen() {

    Scaffold(modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        val viewModel = viewModel<DrawingViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {

            AppDrawingCanvas(
                paths = state.paths,
                currentPath = state.currentPath,
                onAction = viewModel::onAction,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            AppCanvasControls(
                selectedColor = state.selectedColor,
                colors = allColors,
                onSelectColor = {
                    viewModel.onAction(DrawingAction.OnSelectColor(it))
                },
                onClearCanvas = {
                    viewModel.onAction(DrawingAction.OnClearCanvasClick)
                }
            )


        }
    }


}