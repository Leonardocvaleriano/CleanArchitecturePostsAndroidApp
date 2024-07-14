package com.codeplace.mvvmpostsandroidapp.data.datasource

import com.codeplace.mvvmpostsandroidapp.data.network.KtorApiClient
import com.codeplace.mvvmpostsandroidapp.data.network.mappers.toDomain
import com.codeplace.mvvmpostsandroidapp.data.network.models.PostDto
import com.codeplace.mvvmpostsandroidapp.data.network.utils.NetworkError
import com.codeplace.mvvmpostsandroidapp.data.network.utils.Result
import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import com.codeplace.mvvmpostsandroidapp.domain.repositories.PostsRepository
import io.ktor.client.call.body
import kotlinx.serialization.SerializationException
import java.nio.channels.UnresolvedAddressException

class PostRepositoryImpl (
     val apiClient: KtorApiClient
):PostsRepository {
    override suspend fun getPosts(): Result<List<Post>, NetworkError> {
        val response = try {
            apiClient.getPosts()
        } catch(e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch(e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when(response.status.value) {
            in 200..299 -> {
                val posts = response.body<List<PostDto>>().map{
                    it.toDomain()
                }
                Result.Success(posts)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}