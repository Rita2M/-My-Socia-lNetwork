package ru.netology.mysocialnetwork.dto

import androidx.room.Embedded
import java.time.Instant

data class Post(
    val id: Long,
    val authorId: Long,
    val author: String,
    val authorJob: String? = null,
    val authorAvatar: String? = null,
    val content: String,
    val published: String, // string($data-time
    var coords: CoordinatesEmbedded?=null,
    val link: String? = null,
    val mentionIds: Set<Long> , //список упомянули
    val attachment: Attachment? = null,
    val mentionedMe: Boolean, //упомянули обо мне
    val likeOwnerIds: Set<Long> , // error  uniqueItems: true лайкнули меня список
    val likedByMe: Boolean,
   // val users: Map<Long, UserPreview> ,



    )
