package com.codeplace.cleanarchitecturepostsandroidapp.domain.use_case

import com.codeplace.cleanarchitecturepostsandroidapp.domain.repositories.PostsRepository
import javax.inject.Inject

class GetPostCommentUseCase @Inject constructor(
    val postRepository: PostsRepository
) {
    suspend operator fun invoke(id: Int) = postRepository.getComments(id)
}