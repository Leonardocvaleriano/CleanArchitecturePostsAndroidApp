package com.codeplace.mvvmpostsandroidapp.data.datasource

import com.codeplace.mvvmpostsandroidapp.data.network.mappers.toDomain
import com.codeplace.mvvmpostsandroidapp.data.network.models.PostDto
import com.codeplace.mvvmpostsandroidapp.data.network.utils.HttpRoutes
import com.codeplace.mvvmpostsandroidapp.data.network.utils.NetworkError
import com.codeplace.mvvmpostsandroidapp.common.Result

import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import com.codeplace.mvvmpostsandroidapp.domain.repositories.PostsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: HttpClient,
) : PostsRepository {
    override suspend fun getPosts(): Result<List<Post>, NetworkError> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.get(urlString = HttpRoutes.POSTS)
                when (response.status.value) {
                    in 200..299 -> {
                        val postsResponse = response.body<List<PostDto>>()
                        Result.Success(postsResponse.map { it.toDomain() })
                    }
                    401 -> Result.Error(NetworkError.UNAUTHORIZED)
                    409 -> Result.Error(NetworkError.CONFLICT)
                    408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
                    413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
                    else -> {
                        Result.Error(NetworkError.UNKNOWN)
                    }
                }
            } catch (e: UnknownHostException) {
                Result.Error(NetworkError.UNABLE_TO_CONNECT)
            } catch (e: IOException) {
                Result.Error(NetworkError.NO_INTERNET)
            }
        }

    }
}
