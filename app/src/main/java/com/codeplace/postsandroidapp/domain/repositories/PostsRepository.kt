package com.codeplace.postsandroidapp.domain.repositories

import com.codeplace.postsandroidapp.domain.models.Comments
import com.codeplace.postsandroidapp.domain.utils.NetworkError
import com.codeplace.postsandroidapp.domain.utils.Result
import com.codeplace.postsandroidapp.domain.models.Post
import kotlinx.coroutines.flow.StateFlow

interface PostsRepository {

    suspend fun getPosts(): Result<List<Post>, NetworkError>

    suspend fun getPost(id: Int): Result<Post, NetworkError>

    suspend fun getComments(id: Int):Result<List<Comments>, NetworkError>


}