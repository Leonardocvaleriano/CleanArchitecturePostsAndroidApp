package com.codeplace.postsandroidapp.feature_settings.presentation.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codeplace.postsandroidapp.feature_settings.presentation.theme.util.RadioButtonItem

@Composable
fun RadioGroup(
    modifier: Modifier = Modifier,
    items: Iterable<RadioButtonItem>,
    selected: Int,
    onItemSelect: ((Int) -> Unit)?,
){
    Column(
        modifier = modifier.selectableGroup()
    ) {
        items.forEach { item ->
            RadioGroupItem(
                item = item,
                selected = selected == item.id,
                onClick = { onItemSelect?.invoke(item.id) },
                modifier = Modifier.fillMaxWidth(),
                supportText = item.supportText
            )
        }
    }

}