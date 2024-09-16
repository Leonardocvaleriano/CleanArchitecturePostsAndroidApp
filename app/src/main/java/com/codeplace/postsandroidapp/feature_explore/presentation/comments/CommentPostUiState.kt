package com.codeplace.postsandroidapp.feature_explore.presentation.comments

import com.codeplace.postsandroidapp.feature_explore.domain.model.Comment
import com.codeplace.postsandroidapp.feature_explore.domain.model.Post

data class CommentPostUiState(
    val comments:List<Comment> = emptyList(),
    val post:Post? = null,
    val errorPost:String = "",
    val errorComments:String = "",
    val isLoading:Boolean = false,
)