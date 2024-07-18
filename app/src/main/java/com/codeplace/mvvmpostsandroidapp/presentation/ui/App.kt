package com.codeplace.mvvmpostsandroidapp.presentation.ui

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.ErrorMessageScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.PostsScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.PostsViewModel

@Composable
fun App(){
    val viewModel: PostsViewModel = viewModel()

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
        PostsScreen(post = viewModel.posts)
    }
}