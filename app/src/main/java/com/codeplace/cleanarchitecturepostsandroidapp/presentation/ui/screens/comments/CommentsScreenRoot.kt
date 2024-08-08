package com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.screens.comments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeplace.cleanarchitecturepostsandroidapp.R
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Comments
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.components.CommentCard
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.components.PostCard
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.screens.ErrorMessageScreen
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.theme.Spacing
import com.example.compose.AppTheme


@Composable
fun CommentsScreenRoot(
    id: Int,
    viewModel: CommentsViewModel = hiltViewModel(),
) {

    LaunchedEffect(true) {
        viewModel.getCommentsAndPost(id)
    }

    if (viewModel.loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            CircularProgressIndicator()
        }
    } else if (viewModel.error != null) {
        ErrorMessageScreen(errorMessage = viewModel.error!!.name)
    } else {
        CommentsScreen(
            post = viewModel.post!!,
            comments = viewModel.comments
        )
    }

}

@Composable
fun CommentsScreen(
    post: Post,
    comments: List<Comments>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = Spacing.extraLarge, bottom = Spacing.extraLarge)
    ) {
        item {
            PostCard(
                post = post,
                onCardClick = {}
            )
            Spacer(modifier = modifier.height(Spacing.small))
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
            ) {
                Text(
                    modifier = modifier .padding(all = Spacing.large),
                    text = stringResource(id = R.string.comments_title),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

            }

        }
        items(comments) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                    .padding(bottom = Spacing.medium, start = 16.dp, end = 16.dp)
                ,
            ) {
                CommentCard(
                    name = it.name,
                    email = it.email,
                    body = it.body
                )
            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun CommentsScreenPreview() {
    AppTheme {

        CommentsScreen(
            post = Post(
                id = 1,
                title = "Lorem ipsum dolor sit amet consectetur.",
                body = "Lorem ipsum dolor sit amet consectetur. Lorem velit blandit facilisis sollicitudin et molestie mattis tortor. Fusce vitae ut feugiat adipiscing aenean pellentesque ac sagittis nulla. Justo sed dictumst adipiscing egestas phasellus. Erat congue dictum id aenean massa viverra aliquam.",
                userId = 1
            ),
            comments = listOf(
                Comments(
                    body = "Lorem ipsum dolor sit amet consectetur. Lorem velit blandit facilisis sollicitudin et molestie mattis tortor. Fusce vitae ut feugiat adipiscing aenean pellentesque ac sagittis nulla. Justo sed dictumst adipiscing egestas phasellus. Erat congue dictum id aenean massa viverra aliquam.",
                    email = "ikita@garfield.biz",
                    id = 1,
                    name = "Lorem ipsum dolor sit amet consectetur.",
                    postId = 1
                ), Comments(
                    body = "Lorem ipsum dolor sit amet consectetur. Lorem velit blandit facilisis sollicitudin et molestie mattis tortor. Fusce vitae ut feugiat adipiscing aenean pellentesque ac sagittis nulla. Justo sed dictumst adipiscing egestas phasellus. Erat congue dictum id aenean massa viverra aliquam.",
                    email = "ikita@garfield.biz",
                    id = 1,
                    name = "Lorem ipsum dolor sit amet consectetur.",
                    postId = 1
                )
            )
        )
    }
}

