package com.codeplace.mvvmpostsandroidapp.presentation.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.mvvmpostsandroidapp.data.datasource.PostRepositoryImpl
import com.codeplace.mvvmpostsandroidapp.data.network.utils.NetworkError
import com.codeplace.mvvmpostsandroidapp.data.network.utils.Result
import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import com.codeplace.mvvmpostsandroidapp.domain.repositories.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    val postsRepository: PostsRepository
):ViewModel() {

    var posts by mutableStateOf(listOf<Post>())
    var isloading by mutableStateOf(false)
    var errorMessage by mutableStateOf<NetworkError?>(null)


    fun loadPosts() = viewModelScope.launch {
        isloading = true
        when (val result = postsRepository.getPosts()) {
            is Result.Success -> {
                posts = result.data
            }

            is Result.Error -> {
                posts = emptyList()
                errorMessage = result.error
            }
        }
        isloading = false
    }

}