package com.enterprise.userinterfaceelements.presentation.view.components.topappbar


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.enterprise.userinterfaceelements.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(title: @Composable (() -> Unit), navigationIcon: @Composable (() -> Unit) = {}, modifier: Modifier = Modifier){

    TopAppBar(title = { title() }, navigationIcon = { navigationIcon() }, modifier = modifier, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Green))

}