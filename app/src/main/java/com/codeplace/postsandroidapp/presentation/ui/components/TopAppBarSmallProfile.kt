package com.codeplace.postsandroidapp.presentation.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.theme.BorderSize
import com.codeplace.postsandroidapp.presentation.ui.theme.IconSize
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSmallProfile(
    modifier: Modifier = Modifier,
    @StringRes title: Int? = null,
    profileImage: Int,
    secondTrailingIcon:ImageVector,
    thirdTrailingIcon:ImageVector,

) {

    TopAppBar(
        modifier = modifier.padding(start = SpacingSize.large, end = SpacingSize.large),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        title = { Text("") },
        navigationIcon = {
            Image(
                painter = painterResource(profileImage),
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
        },
        actions = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(SpacingSize.extraLarge)
            ){
                Icon(
                    imageVector = secondTrailingIcon,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Icon(
                    imageVector = thirdTrailingIcon,
                    contentDescription = "Notifications Icon",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

        }
    )

}
