package ru.netology.mysocialnetwork.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.mysocialnetwork.dto.Attachment
import ru.netology.mysocialnetwork.dto.CoordinatesEmbedded
import ru.netology.mysocialnetwork.dto.Post
import ru.netology.mysocialnetwork.dto.UserPreview
import java.time.Instant

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val authorId: Long,
    val authorJob: String? = null,
    val author: String,
    val authorAvatar: String? = null,
    val content: String,
    val published: String,
    val link: String? = null,
    val mentionIds: Set<Long>,
    val likedByMe: Boolean,
    val mentionedMe: Boolean,
    val likeOwnerIds: Set<Long>,
    @Embedded
    var coords: CoordinatesEmbedded? = null,
//    @Embedded
//    val users: Map<Long, UserPreview>,
    @Embedded
    val attachment: Attachment? = null,



    //val hidden: Boolean = false,


) {
    fun toDto() = Post(
        id,
        authorId,
        author,
        authorJob,
        authorAvatar,
        content,
        published,
        coords,
        link,
        mentionIds,
        attachment,
        mentionedMe,
        likeOwnerIds,
        likedByMe,
       // users
    )

    companion object {
        fun fromDto(dto: Post) = PostEntity(
            dto.id,
            dto.authorId,
            dto.authorJob,
            dto.author,
            dto.authorAvatar,
            dto.content,
            dto.published,
            dto.link,
            dto.mentionIds,
            dto.likedByMe,
            dto.mentionedMe,
            dto.likeOwnerIds,
            dto.coords,
           // dto.users,
            dto.attachment

        )
    }


}
fun List<Post>.toEntity(): List<PostEntity> = map(PostEntity::fromDto)
fun List<PostEntity>.toDto(): List<Post> = map(PostEntity::toDto)
