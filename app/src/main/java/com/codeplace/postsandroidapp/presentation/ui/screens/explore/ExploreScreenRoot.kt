package com.codeplace.postsandroidapp.presentation.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.domain.models.Post
import com.codeplace.postsandroidapp.presentation.ui.components.PostCard
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarDefault
import com.codeplace.postsandroidapp.presentation.ui.screens.ErrorMessageScreen
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize
import com.example.compose.AppTheme


@Composable
fun HomeScreenRoot(
    viewModel: ExploreViewModel = hiltViewModel(),
    onCardClick: (postId: Int) -> Unit,
    onSearchIconClick:  () -> Unit = {},
    onSendIconClick: () -> Unit = {},
) {

    //Every time that compose make its recompose process, this load post will be called.
    LaunchedEffect(true) {
        viewModel.loadPosts()
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            TopAppBarDefault(
                title = stringResource(R.string.top_bar_title_posts),
                onSearchIconClick = onSearchIconClick,
                onSendIconClick = onSendIconClick
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            if (viewModel.isloading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (viewModel.errorMessage != null) {
                ErrorMessageScreen(errorMessage = viewModel.errorMessage!!.name)
            } else {
                PostsScreen(
                    posts = viewModel.posts,
                    onCardClick = onCardClick,
                    commentsCount = viewModel.commentsCount
                )
            }
        }
    }


}


@Composable
fun PostsScreen(
    posts: List<Post>,
    onCardClick: (Int) -> Unit,
    commentsCount: Int? = 0,
) {

    LazyColumn(
        contentPadding = PaddingValues(top = SpacingSize.small, bottom = SpacingSize.small),
        verticalArrangement = Arrangement.spacedBy(space = SpacingSize.small),
    ) {
        items(posts) {
            PostCard(
                post = it,
                onCardClick = onCardClick,
                containCommentCount = commentsCount
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PostsPreview() {
    AppTheme {
        PostsScreen(posts = listOf(
            Post(
                id = 1,
                title = "Title",
                body = "Body",
                userId = 1,
            ),
            Post(
                id = 1,
                title = "Title",
                body = "Body",
                userId = 1,
            )
        ),
            onCardClick = {}
        )
    }
}
