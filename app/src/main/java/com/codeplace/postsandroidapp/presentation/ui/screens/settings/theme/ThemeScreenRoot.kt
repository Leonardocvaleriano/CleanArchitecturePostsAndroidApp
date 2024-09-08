package com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme.components.RadioGroup
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarBackArrow
import com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme.utils.AppTheme
import com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme.utils.RadioButtonItem
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize

@Composable
fun ThemeScreenRoot(
    modifier: Modifier = Modifier,
    selectedTheme: AppTheme,
    onItemSelected: (AppTheme) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBarBackArrow(title = stringResource(R.string.top_bar_title_theme))
        }
    ) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

            ThemeScreen(
                selectedTheme = selectedTheme,
                onItemSelected = onItemSelected)
        }

    }
}


@Composable
fun ThemeScreen(
    selectedTheme: AppTheme,
    onItemSelected: (AppTheme) -> Unit,
) {


    val themeItems = listOf(
        RadioButtonItem(
            id = AppTheme.LIGHT_MODE.ordinal,
            title = stringResource(R.string.theme_list_item_light)
        ),
        RadioButtonItem(
            id = AppTheme.DARK_MODE.ordinal,
            title = stringResource(R.string.theme_list_item_dark)
        ),
        RadioButtonItem(
            id = AppTheme.SYSTEM_MODE.ordinal,
            title = stringResource(R.string.theme_list_item_System),
            supportText = stringResource(R.string.theme_list_item_System_support)
        )
    )


    Column(modifier = Modifier.padding(horizontal = SpacingSize.large)) {

        RadioGroup(
            items = themeItems,
            selected = selectedTheme.ordinal,
            onItemSelect = {
                onItemSelected(AppTheme.fromOrdinal(it))
            }
        )


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun ThemeScreenPreview() {
   // ThemeScreen()
}



