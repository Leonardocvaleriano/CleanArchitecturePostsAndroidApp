package com.codeplace.mvvmpostsandroidapp.data.network

import android.util.Log
import com.codeplace.mvvmpostsandroidapp.data.network.models.PostDto
import com.codeplace.mvvmpostsandroidapp.data.network.utils.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorApiClient {

    private val httpClient = HttpClient(Android){
        install(Logging){
            logger = object:Logger{
                override fun log(message: String) {
                    Log.d("Http call:", message)
                }
            }
            level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
    }

    suspend fun getPosts(): HttpResponse {
        return httpClient.get(HttpRoutes.POSTS)
    }
}
