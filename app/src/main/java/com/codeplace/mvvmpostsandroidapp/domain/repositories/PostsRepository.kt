package com.codeplace.mvvmpostsandroidapp.domain.repositories

import com.codeplace.mvvmpostsandroidapp.data.network.utils.NetworkError
import com.codeplace.mvvmpostsandroidapp.data.network.utils.Result
import com.codeplace.mvvmpostsandroidapp.domain.models.Post

interface PostsRepository {

    suspend fun getPosts(): Result<List<Post>, NetworkError>

}