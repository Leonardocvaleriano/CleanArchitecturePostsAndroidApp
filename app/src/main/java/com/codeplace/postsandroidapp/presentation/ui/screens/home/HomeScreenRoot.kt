package com.codeplace.postsandroidapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.domain.models.Post
import com.codeplace.postsandroidapp.presentation.ui.components.PostCard
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarSmallProfile
import com.codeplace.postsandroidapp.presentation.ui.screens.ErrorMessageScreen
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize
import com.example.compose.AppTheme


@Composable
fun HomeScreenRoot(
    viewModel: PostsViewModel = hiltViewModel(),
    onCardClick: (postId: Int) -> Unit,
) {

    //Every time that compose make its recompose process, this load post will be called.
    LaunchedEffect(true) {
        viewModel.loadPosts()
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            TopAppBarSmallProfile(
                profileImage = R.drawable.profile_photo,
                secondTrailingIcon = Icons.Filled.Search,
                thirdTrailingIcon = Icons.Filled.Notifications,

                )
        }
    ) { innerPadding ->

        Column(
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
