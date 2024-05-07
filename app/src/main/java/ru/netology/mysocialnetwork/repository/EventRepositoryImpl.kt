package ru.netology.mysocialnetwork.repository

import kotlinx.coroutines.flow.Flow
import ru.netology.mysocialnetwork.dto.Event
import ru.netology.mysocialnetwork.dto.Post
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl(override val data: Flow<Event>) :EventRepository {
    override suspend fun save(post: Post) {
        TODO("Not yet implemented")
    }

    override suspend fun likeById(post: Post) {
        TODO("Not yet implemented")
    }

    override suspend fun removeById(post: Post) {
        TODO("Not yet implemented")
    }
}
