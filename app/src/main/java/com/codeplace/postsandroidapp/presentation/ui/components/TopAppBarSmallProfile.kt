package com.codeplace.postsandroidapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.theme.BorderSize
import com.codeplace.postsandroidapp.presentation.ui.theme.IconSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSmallProfile(
    modifier: Modifier = Modifier,
    title: String? = "",
    onProfileClick: (Int) -> Unit = {} ,
    onSearchClick: () -> Unit = {},
    onNotificationsClick: () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        title = {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = title!!,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    )

        },
        navigationIcon = {
            IconButton(onClick = { onProfileClick(2) }
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_photo),
                    contentDescription = "Profile Photo",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(IconSize.medium)
                        .clip(CircleShape)
                        .border(
                            BorderSize.micro,
                            MaterialTheme.colorScheme.primary,
                            CircleShape
                        )
                )
            }

        },
        actions = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = onNotificationsClick) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notifications Icon",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    )
}


@Preview
@Composable

fun TopAppBarSmallProfilePreview() {
    TopAppBarSmallProfile(
        title = "Favorites"
    )
}