package com.codeplace.postsandroidapp.feature_explore.data.remote.util

object HttpRoutes {
    const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val POSTS = "$BASE_URL/posts"


    fun getPost(postId: Int): String {
        return "$BASE_URL/posts/$postId"

    }
    fun getPosts(): String {
        return "$BASE_URL/posts/"
    }

    fun getPostCommentsByPostId(postId: Int): String {
        return "$BASE_URL/posts/$postId/comments"
    }


}