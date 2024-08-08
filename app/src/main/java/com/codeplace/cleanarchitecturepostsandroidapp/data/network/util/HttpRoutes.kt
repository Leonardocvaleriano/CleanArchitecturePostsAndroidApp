package com.codeplace.cleanarchitecturepostsandroidapp.data.network.util

object HttpRoutes {
    const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val POSTS = "$BASE_URL/posts"


    fun getPost(id: Int): String {
        return "$BASE_URL/posts/$id"

    }
    fun getPosts(): String {
        return "$BASE_URL/posts/"
    }

    fun getPostComments(postId: Int): String {
        return "$BASE_URL/posts/$postId/comments"
    }


}