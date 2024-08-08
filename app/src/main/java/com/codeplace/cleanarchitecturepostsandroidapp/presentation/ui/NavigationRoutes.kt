package com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui

import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class CommentsRoute(val id: Int)


