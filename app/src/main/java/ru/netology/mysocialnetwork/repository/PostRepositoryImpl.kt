package ru.netology.mysocialnetwork.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.netology.mysocialnetwork.dao.PostDao
import ru.netology.mysocialnetwork.dto.Post
import ru.netology.mysocialnetwork.entity.PostEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
private val dao: PostDao
) : PostRepository {

    override val data:Flow<List<Post>> =  dao.getAll().map {
        it.map(PostEntity::toDto)
    }.flowOn(Dispatchers.Default)

    override suspend fun save(post: Post) {
       try {
           dao.insert(PostEntity.fromDto(post))
       }catch (e:Exception){
           throw RuntimeException(e)
       }
    }

    override suspend fun likeById(post: Post) {
        TODO("Not yet implemented")
    }

    override suspend fun removeById(post: Post) {
        TODO("Not yet implemented")
    }
}
