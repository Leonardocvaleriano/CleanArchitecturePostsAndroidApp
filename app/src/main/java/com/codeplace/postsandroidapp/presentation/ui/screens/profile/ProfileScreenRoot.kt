package com.codeplace.postsandroidapp.presentation.ui.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.codeplace.postsandroidapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenRoot(id: Int) {

    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        ), title = {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(id = R.string.top_bar_title_profile)
            )
        }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "ArrowBack Icon",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit Icon",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

        )
    }) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {

            ProfileScreen()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {


}
