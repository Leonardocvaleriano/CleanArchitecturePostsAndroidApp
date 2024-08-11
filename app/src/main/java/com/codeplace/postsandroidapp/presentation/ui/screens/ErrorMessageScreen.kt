package com.codeplace.postsandroidapp.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codeplace.postsandroidapp.presentation.ui.screens.home.PostsViewModel
import kotlinx.coroutines.launch

@Composable
fun ErrorMessageScreen(
    errorMessage: String,
) {

    val viewModel: PostsViewModel = viewModel()
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 48.dp),
    ) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = 18.sp,
            text = "Oops, something went wrong",
        )
        Text(
            fontSize = 14.sp,
            text = errorMessage,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
                Alignment.Center
            //horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Button(onClick = {
                scope.launch {
                    viewModel.loadPosts()
                }

            }) {
                Text(text = "Retry")
            }
        }
    }

    }

}