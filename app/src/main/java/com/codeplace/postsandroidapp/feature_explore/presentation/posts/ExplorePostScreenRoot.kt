package com.codeplace.postsandroidapp.feature_explore.presentation.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.core.presentation.screens.ErrorMessageText
import com.codeplace.postsandroidapp.feature_explore.presentation.posts.components.PostCard
import com.codeplace.postsandroidapp.core.presentation.theme.SpacingSize
import com.codeplace.postsandroidapp.core.presentation.components.TopAppBarDefault
import com.codeplace.postsandroidapp.feature_explore.domain.model.Post


@Composable
fun ExplorePostsScreenRoot(
    viewModel: ExplorePostsViewModel = hiltViewModel(),
    onCardClick: (postId: Int) -> Unit,
    onSearchIconClick: () -> Unit = {},
    onSendIconClick: () -> Unit = {},
) {

    val isLoading by viewModel.isLoading.collectAsState()
    val posts by viewModel.posts.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            TopAppBarDefault(
                title = stringResource(R.string.top_bar_title_explore),
                onSearchIconClick = onSearchIconClick,
                onSendIconClick = onSendIconClick
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (errorMessage.isNotEmpty()) {
                ErrorMessageText(
                    errorMessage = errorMessage,
                )
            } else {
                PostsScreen(
                    posts = posts,
                    onCardClick = onCardClick
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
        items(posts) { post ->
            PostCard(
                post = post,
                onCardClick = onCardClick,
                containCommentCount = commentsCount
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PostsPreview() {

//    val postList = listOf(
//        Post(
//            id = 1,
//            title = "Title",
//            body = "Body",
//            userId = 1,
//        ), Post(
//            id = 1,
//            title = "Title",
//            body = "Body",
//            userId = 1,
//        )
//    )
//        PostsScreen(
//            posts = postList,
//            onCardClick = {},
//            commentsCount = 1
//        )

}
