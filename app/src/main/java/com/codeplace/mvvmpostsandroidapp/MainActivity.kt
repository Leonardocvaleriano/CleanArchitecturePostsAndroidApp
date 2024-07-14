package com.codeplace.mvvmpostsandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.PostsScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.PostsViewModel
import com.codeplace.mvvmpostsandroidapp.presentation.ui.theme.MVVMPostsAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: PostsViewModel by viewModels<PostsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val posts  = viewModel.posts

            MVVMPostsAndroidAppTheme{
                LaunchedEffect(true){
                    viewModel.loadPosts()
                }

                PostsScreen(posts)

                }
            }
        }
    }

