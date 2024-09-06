package com.codeplace.postsandroidapp.presentation.ui.screens.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.postsandroidapp.domain.utils.NetworkError
import com.codeplace.postsandroidapp.domain.utils.onError
import com.codeplace.postsandroidapp.domain.utils.onSuccess
import com.codeplace.postsandroidapp.domain.models.Post
import com.codeplace.postsandroidapp.domain.use_case.GetCommentByIdUseCase
import com.codeplace.postsandroidapp.domain.use_case.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val getCommentByIdUseCase: GetCommentByIdUseCase
):ViewModel() {

    var posts by mutableStateOf(listOf<Post>())
        private set
    var isloading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<NetworkError?>(null)
        private set



    var commentsCount by mutableStateOf<Int>(0)
    var errorMessageCommentsCount by mutableStateOf<NetworkError?>(null)
        private set


    fun loadPosts() = viewModelScope.launch {
        isloading = true
            getPostsUseCase().onSuccess {
                posts = it
                isloading = false
                errorMessage = null

                posts.forEach {
                    getCommentByIdUseCase(it.id)
                        .onSuccess {
                        commentsCount = it.size
                    }.onError {
                        errorMessageCommentsCount = it
                    }
                }
            }. onError {
                errorMessage = it
            }

    }
}