package com.codeplace.postsandroidapp.feature_explore.domain.use_case

data class GetPostUseCases(
    val getPostsUseCase: GetPostsUseCase,
    val getCommentsByPostIdUseCase: GetCommentsByPostIdUseCase,
    val getPostByPostIdUseCase: GetPostByPostIdUseCase
)
