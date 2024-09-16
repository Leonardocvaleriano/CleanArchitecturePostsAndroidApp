package com.codeplace.postsandroidapp.feature_explore.domain.model

data class Comment(
    val postId:Int,
    val id:Int,
    val name:String,
    val email:String,
    val body:String
)
