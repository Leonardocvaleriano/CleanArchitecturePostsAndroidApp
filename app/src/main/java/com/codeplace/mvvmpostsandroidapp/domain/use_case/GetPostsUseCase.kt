package com.codeplace.mvvmpostsandroidapp.domain.use_case

import com.codeplace.mvvmpostsandroidapp.domain.repositories.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
   private val postRepository: PostsRepository
) {

    suspend operator fun invoke() = postRepository.getPosts()
}