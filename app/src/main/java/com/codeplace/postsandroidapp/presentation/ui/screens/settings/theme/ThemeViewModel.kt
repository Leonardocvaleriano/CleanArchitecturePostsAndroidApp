package com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme.utils.AppTheme

class ThemeViewModel(
): ViewModel(){

   var currentTheme by mutableStateOf(AppTheme.SYSTEM_MODE)


}