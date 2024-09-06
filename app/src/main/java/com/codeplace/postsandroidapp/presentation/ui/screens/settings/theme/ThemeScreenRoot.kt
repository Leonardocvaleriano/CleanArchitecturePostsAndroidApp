package com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarBackArrow

@Composable
fun ThemeScreenRoot(){

    Scaffold(
        topBar = {
            TopAppBarBackArrow(title = stringResource(R.string.top_bar_title_theme))
        }
    ){

        innerPadding ->
            ThemeScreen(paddingValues = innerPadding)
    }
}

@Composable
fun ThemeScreen(paddingValues: PaddingValues){



}


