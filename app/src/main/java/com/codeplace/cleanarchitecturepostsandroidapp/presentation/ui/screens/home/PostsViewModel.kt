package com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.NetworkError
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.onError
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.onSuccess
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post
import com.codeplace.cleanarchitecturepostsandroidapp.domain.use_case.GetPostsUseCase
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