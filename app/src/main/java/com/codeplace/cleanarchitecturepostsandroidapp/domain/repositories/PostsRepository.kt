package com.codeplace.cleanarchitecturepostsandroidapp.domain.repositories

import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Comments
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.NetworkError
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.Result
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post

interface PostsRepository {

    suspend fun getPosts(): Result<List<Post>, NetworkError>

    suspend fun getPost(id: Int): Result<Post, NetworkError>

    suspend fun getComments(id: Int):Result<List<Comments>, NetworkError>


}