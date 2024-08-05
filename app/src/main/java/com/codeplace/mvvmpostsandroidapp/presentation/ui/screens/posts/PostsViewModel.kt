package com.codeplace.mvvmpostsandroidapp.presentation.ui.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.mvvmpostsandroidapp.data.network.utils.NetworkError
import com.codeplace.mvvmpostsandroidapp.common.onError
import com.codeplace.mvvmpostsandroidapp.common.onSuccess
import com.codeplace.mvvmpostsandroidapp.domain.models.Post
import com.codeplace.mvvmpostsandroidapp.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    val getPostsUseCase: GetPostsUseCase
):ViewModel() {

    var posts by mutableStateOf(listOf<Post>())
        private set
    var isloading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<NetworkError?>(null)
        private set


    fun loadPosts() = viewModelScope.launch {
        isloading = true
            getPostsUseCase().onSuccess {
                isloading = false
                posts = it
                isloading = false
                errorMessage = null
            }
                .onError {
                    isloading = false
                    errorMessage = it
                }
    }
}