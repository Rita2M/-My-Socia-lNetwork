package ru.netology.mysocialnetwork.repository

import kotlinx.coroutines.flow.Flow
import ru.netology.mysocialnetwork.dto.Event
import ru.netology.mysocialnetwork.dto.Post

interface EventRepository
{
    val data: Flow<Event>
    suspend fun save(post: Post)
    suspend fun likeById(post: Post)
    suspend fun removeById(post: Post)
}
