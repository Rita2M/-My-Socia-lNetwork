package ru.netology.mysocialnetwork.dto

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ru.netology.mysocialnetwork.utils.Converters
import java.time.Instant

data class Event(
    val id: Long,
    val authorId: Long,
    val author: String,
    val authorJob: String? = null,
    val authorAvatar: String? = null,
    val content: String,
    val datetime: String, // string($data-time
    val published: String, // string($data-time
   // var type: TypeEvent, // enum online offline
    val likeOwnerIds: Set<Long>, // error  uniqueItems: true
    val likedByMe: Boolean,
    val attachment: Attachment? = null,
    val participantsIds: Set<Long>, //Error  uniqueItems: true //участники
    val participatedByMe: Boolean,
    var coordinates: CoordinatesEmbedded?=null,
    val link: String? = null,
    val speakerIds: Set<Long>, // Error 	 uniqueItems: true
    //val users: Map<Long, UserPreview> ,


    )
