package com.codeplace.postsandroidapp.core.presentation.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CircularProgressIndicatorStandard(
    color: Color = MaterialTheme.colorScheme.primary
){
    CircularProgressIndicator(
        color = color
    )

}