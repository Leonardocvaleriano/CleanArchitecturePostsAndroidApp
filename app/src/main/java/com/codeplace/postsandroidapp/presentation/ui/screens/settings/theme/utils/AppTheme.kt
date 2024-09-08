package com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme.utils

enum class AppTheme {
    LIGHT_MODE,
    DARK_MODE,
    SYSTEM_MODE;

    companion object {
        fun fromOrdinal(ordinal: Int) = entries[ordinal]
    }
}