package com.codeplace.postsandroidapp.data.datasource

import com.codeplace.postsandroidapp.data.network.mappers.toDomain
import com.codeplace.postsandroidapp.data.network.models.CommentsDto
import com.codeplace.postsandroidapp.data.network.models.PostDto
import com.codeplace.postsandroidapp.data.network.util.HttpRoutes
import com.codeplace.postsandroidapp.domain.models.Comments
import com.codeplace.postsandroidapp.domain.utils.NetworkError
import com.codeplace.postsandroidapp.domain.utils.Result

import com.codeplace.postsandroidapp.domain.models.Post
import com.codeplace.postsandroidapp.domain.repositories.PostsRepository
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
                        val postsDto = response.body<List<PostDto>>()
                        Result.Success(postsDto.map { it.toDomain() })
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


    override suspend fun getPost(id: Int): Result<Post, NetworkError> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.get(urlString = HttpRoutes.getPost(id = id))
                when (response.status.value) {
                    in 200..299 -> {
                        val postDto = response.body<PostDto>()
                        Result.Success(data = postDto.toDomain())
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

    override suspend fun getComments(id: Int): Result<List<Comments>, NetworkError> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.get(urlString = HttpRoutes.getPostComments(postId = id))
                when (response.status.value) {
                    in 200..299 -> {
                        val commentsDto = response.body<List<CommentsDto>>()
                        Result.Success(commentsDto.map { it.toDomain() })
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
