package com.codeplace.postsandroidapp.presentation.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarTrailingIcon
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize


@Composable
fun SettingsScreenRoot(
    onThemeClick: () -> Unit = {},
) {


    Scaffold(
        topBar = {
            TopAppBarTrailingIcon(
                title = stringResource(R.string.top_bar_title_settings)
            )
        }

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SettingsScreen(
                onThemeClick = onThemeClick
            )
        }
    }


}

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onThemeClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = SpacingSize.medium)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(SpacingSize.large)) {
                SettingsItemRow(
                    text = stringResource(R.string.theme_settings_item),
                    icon = Icons.Outlined.Settings,
                    contentDescription = "Settings Icon",
                    onItemClick = onThemeClick
                )
                SettingsItemRow(
                    text = stringResource(R.string.share_settings_item),
                    icon = Icons.Outlined.Share,
                    contentDescription = "Share Icon"
                )
            }
        }


    }
}


@Composable
fun SettingsItemRow(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    onItemClick:() -> Unit = {},
    contentDescription: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier.clickable {
                onItemClick()
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SpacingSize.medium)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(
        onThemeClick = {}
    )
}