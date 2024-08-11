package com.codeplace.postsandroidapp.domain.use_case

import com.codeplace.postsandroidapp.domain.repositories.PostsRepository
import javax.inject.Inject

class GetPostByIdUseCase @Inject constructor(
    private val postsRepository: PostsRepository
) {
    suspend operator fun invoke(id: Int) = postsRepository.getPost(id = id)

}