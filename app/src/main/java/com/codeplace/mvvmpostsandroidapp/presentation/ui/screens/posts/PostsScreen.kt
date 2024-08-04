package com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import com.codeplace.mvvmpostsandroidapp.presentation.ui.components.PostCard
import com.codeplace.mvvmpostsandroidapp.presentation.ui.theme.Spacing
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun PostsScreen(
        post:List<Post>
) {
        Scaffold (
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
        ){ innerPadding ->
            Column(modifier =
            Modifier
                .padding(innerPadding)

            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(space = Spacing.small),
                ){
                    items(post) {
                        PostCard(post = it)
                    }
                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PostsPreview() {
        AppTheme {
            PostsScreen(post = listOf(
                Post(
                id = 1,
                title = "Title",
                body = "Body",
                userId = 1
            ),
                Post(
                    id = 1,
                    title = "Title",
                    body = "Body",
                    userId = 1
                )

                ))
        }
    }
