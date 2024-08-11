package com.codeplace.postsandroidapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class CommentsDto(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)