package com.codeplace.mvvmpostsandroidapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PostCard(){

    Column(){
        Text("Post Title")
        Text("Post Body")
    }
}


@Preview
@Composable
fun PosdCardPreview(){
    PostCard()
}