package com.codeplace.postsandroidapp.presentation.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.postsandroidapp.domain.utils.NetworkError
import com.codeplace.postsandroidapp.domain.utils.onError
import com.codeplace.postsandroidapp.domain.utils.onSuccess
import com.codeplace.postsandroidapp.domain.models.Post
import com.codeplace.postsandroidapp.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
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