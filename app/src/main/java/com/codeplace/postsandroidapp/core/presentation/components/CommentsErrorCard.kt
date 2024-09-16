package com.codeplace.postsandroidapp.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

@Composable
fun StandardCard(
    modifier:Modifier = Modifier,
    cardColor: Color = MaterialTheme.colorScheme.surfaceContainerLowest,
    containEffectOnClick:Boolean = false,
    bodyMessage:String
) {
    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = modifier
            .padding()
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = if (containEffectOnClick) rememberRipple() else null
            ) {
                ///onCardClick(post.id)
            }
        ,
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            contentColor = MaterialTheme.colorScheme.onSurface
    ),
        shape = RectangleShape,
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {

            Text(text = bodyMessage)

        }
    }

}