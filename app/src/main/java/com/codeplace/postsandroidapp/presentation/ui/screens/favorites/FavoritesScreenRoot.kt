package com.codeplace.postsandroidapp.presentation.ui.screens.favorites

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarSmallProfile
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize

@Composable
fun FavoritesScreenRoot(
    modifier: Modifier = Modifier,
    onProfileClick: (Int) -> Unit = {},
) {
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            TopAppBarSmallProfile(
                onProfileClick = onProfileClick,
                title = stringResource(R.string.top_bar_title_favorites)
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            FavoritesScreen()
        }

    }
}

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
  Column(modifier = modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = "Favorites Screen")

  }
}


@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreenRoot()
}
