package com.codeplace.postsandroidapp.feature_favorites.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.core.presentation.components.TopAppBarTrailingIcon

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
