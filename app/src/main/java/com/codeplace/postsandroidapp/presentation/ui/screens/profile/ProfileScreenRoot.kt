package com.codeplace.postsandroidapp.presentation.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenRoot(id: Int) {

    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
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
fun ProfileScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .wrapContentHeight()
            .padding(vertical = SpacingSize.large, horizontal = SpacingSize.large),
    ) {
        Row(modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(SpacingSize.medium)) {
            Image(
                painter = painterResource(id = R.drawable.profile_photo),
                contentDescription = stringResource(id = R.string.profile_content_description),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
                Column(
                    modifier = modifier.height(80.dp),
                    verticalArrangement = Arrangement.Center) {

                    Column(verticalArrangement = Arrangement.spacedBy(SpacingSize.nano)     ) {
                        Text(
                            text = "Lorem ipsum dolor",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Joined April 2024",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                }



        }

    }


}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreenRoot(id = 1)
}
