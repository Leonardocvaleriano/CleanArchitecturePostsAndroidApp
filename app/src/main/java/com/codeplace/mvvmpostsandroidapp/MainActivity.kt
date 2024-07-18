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
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.ErrorMessageScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.PostsScreen
import com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts.PostsViewModel
import com.codeplace.mvvmpostsandroidapp.presentation.ui.theme.MVVMPostsAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PostsViewModel by viewModels<PostsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMPostsAndroidAppTheme {
                 //Every time that compose make it recompose process, this load post will be called.
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
                } else if(viewModel.errorMessage != null) {
                        ErrorMessageScreen(errorMessage = viewModel.errorMessage!!.name)
                    } else {
                        PostsScreen(post =viewModel.posts)
                }
                }
            }
        }
    }
    @Preview
    @Composable
    fun ErrorMessageScreenPreview(){
        MVVMPostsAndroidAppTheme{
                ErrorMessageScreen(errorMessage = "error tes")
        }

    }



