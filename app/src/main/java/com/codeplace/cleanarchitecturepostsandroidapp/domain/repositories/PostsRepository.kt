package com.codeplace.cleanarchitecturepostsandroidapp.domain.repositories

import com.codeplace.cleanarchitecturepostsandroidapp.data.network.utils.NetworkError
import com.codeplace.cleanarchitecturepostsandroidapp.common.Result
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post

interface PostsRepository {

    suspend fun getPosts(): Result<List<Post>, NetworkError>

}