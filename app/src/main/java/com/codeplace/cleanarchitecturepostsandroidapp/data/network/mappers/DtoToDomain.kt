package com.codeplace.cleanarchitecturepostsandroidapp.data.network.mappers

import com.codeplace.cleanarchitecturepostsandroidapp.data.network.models.CommentsDto
import com.codeplace.cleanarchitecturepostsandroidapp.data.network.models.PostDto
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Comments
import com.codeplace.cleanarchitecturepostsandroidapp.domain.models.Post


fun PostDto.toDomain(): Post {
    return Post(
        userId = this.userId,
        id = this.id,
        title = this.title,
        body = this.body
        )
}

fun CommentsDto.toDomain(): Comments {
    return Comments(
        body = this.body,
        email = this.email,
        id = this.id,
        name = this.name,
        postId = this.postId
    )
}



