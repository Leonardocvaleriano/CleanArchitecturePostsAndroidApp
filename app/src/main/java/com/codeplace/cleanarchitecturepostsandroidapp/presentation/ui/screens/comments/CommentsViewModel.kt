package com.codeplace.cleanarchitecturepostsandroidapp.presentation.ui.screens.comments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Comments
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post
import com.codeplace.cleanarchitecturepostsandroidapp.domain.use_case.GetPostCommentUseCase
import com.codeplace.cleanarchitecturepostsandroidapp.domain.use_case.GetPostByIdUseCase
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.NetworkError
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.onError
import com.codeplace.cleanarchitecturepostsandroidapp.domain.utils.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    val getPostCommentsUseCase: GetPostCommentUseCase,
    val getPostByIdUseCase: GetPostByIdUseCase
) : ViewModel() {

    var post by mutableStateOf<Post?>(Post(
        id = -1,
        title = "",
        body = "",
        userId = -1
    ))
        private set

    var comments by mutableStateOf(listOf<Comments>())
        private set

    var error by mutableStateOf<NetworkError?>(null)

    var loading by mutableStateOf(false)
        private set



    fun getCommentsAndPost(id: Int) = viewModelScope.launch {
        loading = true

        getPostCommentsUseCase(id = id).onSuccess {
            comments = it
        }.onError {
            error = it
        }

        getPostByIdUseCase(id).onSuccess {
            post = it
        }.onError {
            error = it
        }
        loading = false
    }

}
