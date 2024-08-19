package com.codeplace.postsandroidapp.presentation.ui.screens.settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize


@Composable
fun SettingsScreenRoot() {

    SettingsScreen()
}


@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = SpacingSize.massive,
                bottom = SpacingSize.large,
                start = SpacingSize.large,
                end = SpacingSize.large
            ),
        verticalArrangement = Arrangement.spacedBy(SpacingSize.extraLarge)

    ) {
        Text(
            text = stringResource(R.string.settings_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )


        Column(verticalArrangement = Arrangement.spacedBy(SpacingSize.small)) {
            SettingsItemRow(
                text = stringResource(R.string.light_mode_settings_item),
                icon = Icons.Outlined.Settings,
                containToggleButton = true,
                contentDescription = "Theme Mode Icon",
                onClick = {}
            )
            SettingsItemRow(
                text = stringResource(R.string.share_settings_item),
                icon = Icons.Outlined.Share,
                containToggleButton = false,
                contentDescription = "Share Icon",
                onClick = {}
            )
            HorizontalDivider(
                modifier = modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.outlineVariant
            )
            SettingsItemRow(
                text = stringResource(R.string.logout_settings_item),
                icon = Icons.AutoMirrored.Outlined.ExitToApp,
                containToggleButton = false,
                contentDescription = "Logout Icon",
                onClick = {}
            )
        }

    }

}

@Composable
fun SettingsItemRow(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    containToggleButton: Boolean,
    onClick: () -> Unit = {},
    contentDescription: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SpacingSize.extraSmall)
        ) {
            IconButton(
                onClick = onClick,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
        if (containToggleButton){
            Switch(
                checked = if (isSystemInDarkTheme()){
                    true
                } else {
                    false
                },
                onCheckedChange = {},
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                )
            )
        }




    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()

}