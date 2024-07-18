package com.codeplace.mvvmpostsandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.mvvmpostsandroidapp.presentation.ui.App
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.ErrorMessageScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.PostsScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.PostsViewModel
import com.codeplace.mvvmpostsandroidapp.presentation.ui.theme.MVVMPostsAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentCompose()

    }
}

private fun ComponentActivity.setContentCompose() {
    enableEdgeToEdge()
    setContent {
        MVVMPostsAndroidAppTheme {
            App()
        }
    }
}
