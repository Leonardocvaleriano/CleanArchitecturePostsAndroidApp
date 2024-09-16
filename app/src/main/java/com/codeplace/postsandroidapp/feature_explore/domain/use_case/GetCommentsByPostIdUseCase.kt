package com.codeplace.postsandroidapp.feature_explore.domain.use_case

import com.codeplace.postsandroidapp.feature_explore.domain.repository.PostsRepository
import javax.inject.Inject

class GetCommentsByPostIdUseCase @Inject constructor(
    val postRepository: PostsRepository
) {
    suspend operator fun invoke(postId: Int) = postRepository.getCommentsByPostId(postId = postId)
}