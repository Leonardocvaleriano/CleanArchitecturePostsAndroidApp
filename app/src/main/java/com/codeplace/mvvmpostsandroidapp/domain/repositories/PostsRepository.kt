package com.codeplace.mvvmpostsandroidapp.domain.repositories

import android.util.Log
import com.codeplace.mvvmpostsandroidapp.data.datasource.PostRepositoryImpl
import com.codeplace.mvvmpostsandroidapp.data.network.utils.Error
import com.codeplace.mvvmpostsandroidapp.data.network.utils.NetworkError
import com.codeplace.mvvmpostsandroidapp.data.network.utils.Result
import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface PostsRepository {

    suspend fun getPosts():Result<List<Post>,NetworkError>

}