package com.codeplace.mvvmpostsandroidapp.di

import android.util.Log
import com.codeplace.mvvmpostsandroidapp.data.datasource.PostRepositoryImpl
import com.codeplace.mvvmpostsandroidapp.domain.repositories.PostsRepository
import dagger.Component.Factory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideService():HttpClient{
        return HttpClient(Android){
            install(Logging){
                logger = object: Logger {
                    override fun log(message: String) {
                        Log.d("Http call:", message)
                    }
                }
                level = LogLevel.BODY
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

    }

    @Provides
    @Singleton
    fun providePostsRepository(api: HttpClient):PostsRepository{
        return PostRepositoryImpl(api)
    }
}