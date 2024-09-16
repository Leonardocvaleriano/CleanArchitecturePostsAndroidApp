package com.codeplace.postsandroidapp.feature_explore.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CommentDto(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)
