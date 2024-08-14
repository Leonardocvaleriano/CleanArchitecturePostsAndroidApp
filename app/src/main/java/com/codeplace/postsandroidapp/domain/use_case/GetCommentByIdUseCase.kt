package com.codeplace.postsandroidapp.domain.use_case

import com.codeplace.postsandroidapp.domain.repositories.PostsRepository
import javax.inject.Inject

class GetCommentByIdUseCase @Inject constructor(
    val postRepository: PostsRepository
) {
    suspend operator fun invoke(id: Int) = postRepository.getComments(id)
}