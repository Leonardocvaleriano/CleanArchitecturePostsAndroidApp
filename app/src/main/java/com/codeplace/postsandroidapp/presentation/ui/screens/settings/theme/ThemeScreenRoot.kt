package com.codeplace.postsandroidapp.presentation.ui.screens.settings.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.postsandroidapp.R
import com.codeplace.postsandroidapp.presentation.ui.components.TopAppBarBackArrow
import com.codeplace.postsandroidapp.presentation.ui.theme.SpacingSize

@Composable
fun ThemeScreenRoot() {

    Scaffold(
        topBar = {
            TopAppBarBackArrow(title = stringResource(R.string.top_bar_title_theme))
        }
    ) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

            ThemeScreen()
        }

    }
}

@Composable
fun ThemeScreen() {
    Column(modifier = Modifier.padding(horizontal = SpacingSize.large)) {
        ThemeItemRow(
            text = stringResource(R.string.theme_list_item_on)
        )
        ThemeItemRow(
            text = stringResource(R.string.theme_list_item_off)
        )
        ThemeItemRow(
            text = stringResource(R.string.theme_list_item_System),
            supportText = stringResource(R.string.theme_list_item_System_support)
        )
    }

}


@Composable
fun ThemeItemRow(
    text: String,
    supportText: String? = null,
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if(supportText != null){
            Column(verticalArrangement = Arrangement.spacedBy(SpacingSize.nano)) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    text = supportText,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Normal
                )
            }
        } else {
            Text(
                modifier = Modifier.fillMaxWidth(0.9f),
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )

        }


        RadioButton(
            colors = RadioButtonColors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledSelectedColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.38f),
                disabledUnselectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            ),
            enabled = false, selected = false, onClick = {})
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable

fun ThemeScreenPreview() {
    ThemeScreen()
}



