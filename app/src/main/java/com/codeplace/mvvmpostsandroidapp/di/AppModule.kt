package com.codeplace.mvvmpostsandroidapp.di

import com.codeplace.mvvmpostsandroidapp.data.datasource.PostRepositoryImpl
import com.codeplace.mvvmpostsandroidapp.data.network.KtorApiClient
import com.codeplace.mvvmpostsandroidapp.domain.repositories.PostsRepository
import dagger.Component.Factory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideService():KtorApiClient{
        return KtorApiClient()
    }

    @Provides
    @Singleton
    fun provideViewModel(client:KtorApiClient):PostsRepository{
        return PostRepositoryImpl(client)

    }
}