package ru.netology.mysocialnetwork.repository

import kotlinx.coroutines.flow.Flow
import ru.netology.mysocialnetwork.dto.Post

interface PostRepository {
    val data : Flow<List<Post>>
suspend fun save(post: Post)
suspend fun likeById(post: Post)
suspend fun removeById(post: Post)
}
