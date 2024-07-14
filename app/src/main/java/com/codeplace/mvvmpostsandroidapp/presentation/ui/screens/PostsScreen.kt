package com.codeplace.mvvmpostsandroidapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import com.codeplace.mvvmpostsandroidapp.presentation.ui.mock.PostMock
import com.codeplace.mvvmpostsandroidapp.presentation.ui.theme.MVVMPostsAndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun PostsScreen(
        post:List<Post>
) {
        Scaffold (
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Post")
                    }
                )
            }
        ){ innerPadding ->
            Column(modifier =
            Modifier.padding(innerPadding)) {


                LazyColumn {
                    items(post) {
                        Column(
                            Modifier
                            .fillMaxSize()
                            .padding(24.dp)
                        ) {
                            Text(it.title!!)
                            Spacer(modifier = Modifier.padding(top = 14.dp))
                            Text(it.body!!)
                        }

                    }
                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PostsPreview() {
        MVVMPostsAndroidAppTheme {
            //PostsScreen()
        }
    }
