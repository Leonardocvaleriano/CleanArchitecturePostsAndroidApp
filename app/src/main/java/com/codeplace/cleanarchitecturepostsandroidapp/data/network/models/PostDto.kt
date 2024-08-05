package com.codeplace.cleanarchitecturepostsandroidapp.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)