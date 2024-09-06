package com.codeplace.postsandroidapp.presentation.ui.screens.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarDefault
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarTrailingIcon
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize

@Composable
fun FavoritesScreenRoot(
    modifier: Modifier = Modifier,
    onSendIconClick: () -> Unit = {},
    onSearchIconClick: () -> Unit = {},
) {

    Scaffold(
        topBar = {
            TopAppBarTrailingIcon(
                iconText = stringResource(R.string.edit_icon_text),
                title = stringResource(R.string.top_bar_title_favorites)

                )
        }
    ) { innerPadding ->
        Box(modifier = modifier.padding(innerPadding)){
            FavoritesScreen()
        }
    }
}
@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreenRoot()
}
