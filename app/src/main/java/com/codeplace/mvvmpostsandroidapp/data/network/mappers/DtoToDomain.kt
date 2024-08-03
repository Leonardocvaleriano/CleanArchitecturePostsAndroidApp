package com.codeplace.mvvmpostsandroidapp.data.network.mappers

import com.codeplace.mvvmpostsandroidapp.data.network.models.PostDto
import com.codeplace.mvvmpostsandroidapp.domain.models.Post


fun PostDto.toDomain(): Post {
    return Post(
        userId = this.userId,
        id = this.id,
        title = this.title,
        body = this.body
        )
}

