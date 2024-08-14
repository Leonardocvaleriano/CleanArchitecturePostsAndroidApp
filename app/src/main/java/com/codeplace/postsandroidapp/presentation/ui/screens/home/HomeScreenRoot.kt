package com.codeplace.postsandroidapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codeplace.postsandroidapp.domain.models.Post
import com.codeplace.postsandroidapp.presentation.ui.components.PostCard
import com.codeplace.postsandroidapp.presentation.ui.screens.ErrorMessageScreen
import com.codeplace.postsandroidapp.presentation.ui.theme.Spacing
import com.example.compose.AppTheme


@Composable
fun HomeScreenRoot(
    viewModel: PostsViewModel = hiltViewModel(),
    onCardClick: (postId:Int) -> Unit,
) {

    //Every time that compose make its recompose process, this load post will be called.
    LaunchedEffect(true) {
        viewModel.loadPosts()
    }

    if (viewModel.isloading) {
        Box(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    posts: List<Post>,
    onCardClick: (Int) -> Unit,
    commentsCount:Int? = 0,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                ),
                title = {
                    Text(
                        text = "Posts",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier =
            Modifier
                .padding(innerPadding)

        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(space = Spacing.small),
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
                userId = 1,)
        ),
            onCardClick = {}
        )
    }
}
