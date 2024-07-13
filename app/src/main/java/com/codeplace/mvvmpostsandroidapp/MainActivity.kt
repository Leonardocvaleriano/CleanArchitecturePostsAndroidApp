package com.codeplace.mvvmpostsandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.mvvmpostsandroidapp.ui.mock.PostMock
import com.codeplace.mvvmpostsandroidapp.ui.theme.MVVMPostsAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMPostsAndroidAppTheme{

                Posts()

                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Posts() {
    val postsMock:ArrayList<PostMock> = arrayListOf(PostMock())
    for (i in 1..100){
        postsMock.add(PostMock())
    }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Posts")
                }
            )
        }
    ){ innerPadding ->
        Column(modifier =
        Modifier.padding(innerPadding)) {
            LazyColumn {
                items(postsMock) {
                    Column(Modifier
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
        Posts()
    }
}