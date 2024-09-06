package com.codeplace.postsandroidapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.codeplace.postsandroidapp.presentation.ui.navigation.NavigationRoot
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentCompose()
    }

    private fun ComponentActivity.setContentCompose() {
        enableEdgeToEdge()
        setContent {

           NavigationRoot()
        }
    }

}