package com.codeplace.postsandroidapp.presentation.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarTrailingIcon(
    onEditClick: () -> Unit = {},
    iconText:String = "",
    title:String = ""
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.onSurface
            ),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Text(text = iconText)
            }

        }
    )
}