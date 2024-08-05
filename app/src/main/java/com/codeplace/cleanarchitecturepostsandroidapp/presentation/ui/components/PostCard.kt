package com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post
import com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.theme.Spacing
import com.example.compose.AppTheme

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    post:Post ,
) {
    Card(
        modifier = modifier
            .padding()
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
        )
        ,
        shape = RectangleShape
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = Spacing.medium, end = Spacing.medium, top = Spacing.medium, bottom = Spacing.large),
            verticalArrangement = Arrangement.spacedBy(Spacing.small)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = post.body,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}


@Preview
@Composable
fun PosdCardPreview() {
    AppTheme {
        PostCard(
            post = Post(
                title = "Lorem ipsum dolor sit amet consectetur.",
                body = "Lorem ipsum dolor sit amet consectetur. Lorem velit blandit facilisis sollicitudin et molestie mattis tortor. Fusce vitae ut feugiat adipiscing aenean pellentesque ac sagittis nulla. Justo sed dictumst adipiscing egestas phasellus. Erat congue dictum id aenean massa viverra aliquam.",
                id = -1,
                userId = -1
            )
        )
    }

}