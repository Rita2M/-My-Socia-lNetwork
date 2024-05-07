package ru.netology.mysocialnetwork.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.netology.mysocialnetwork.dto.Attachment
import ru.netology.mysocialnetwork.dto.CoordinatesEmbedded
import ru.netology.mysocialnetwork.dto.Event
import ru.netology.mysocialnetwork.dto.TypeEvent
import ru.netology.mysocialnetwork.dto.UserPreview


@Entity
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val authorId: Long,
    val author: String,
    val authorAvatar: String? = null,
    val authorJob: String? = null,
    val content: String,
    val datetime: String,
    val published: String,
    //@Embedded
   // var type: TypeEvent,
    val likeOwnerIds: Set<Long>, // error  uniqueItems: true
    val likedByMe: Boolean,
    val participantsIds: Set<Long>, //Error  uniqueItems: true
    val participatedByMe: Boolean,
    val link: String? = null,
    val speakerIds: Set<Long>, // Error 	 uniqueItems: true
    @Embedded
    var coords: CoordinatesEmbedded? = null,
//    @Embedded
//    val users: Map<Long, UserPreview> ,
    @Embedded
    val attachment: Attachment? = null,
    ){ //constructor() : this(0, 0, "", null, null, "", "", "", TypeEvent.OFFLINE, emptySet(), false, emptySet(), false, null, emptySet(), null, emptyMap(), null)
    fun toDto() = Event(
        id,
        authorId,
        author,
        authorJob,
        authorAvatar,
        content,
        datetime,
        published,
       // type,
        likeOwnerIds,
        likedByMe,
        attachment,
        participantsIds,
        participatedByMe,
        coords,
        link,
        speakerIds,
       // users
    )

    companion object {
        fun fromDto(dto: Event) = EventEntity(
            dto.id,
            dto.authorId,
            dto.author,
            dto.authorAvatar,
            dto.authorJob,
            dto.content,
            dto.datetime,
            dto.published,
           // dto.type,
            dto.likeOwnerIds,
            dto.likedByMe,
            dto.participantsIds,
            dto.participatedByMe,
            dto.link,
            dto.speakerIds,
            dto.coordinates,
            //dto.users,
            dto.attachment,


            )
    }
}
fun List<Event>.toEntity(): List<EventEntity> = map(EventEntity::fromDto)
fun List<EventEntity>.toDto(): List<Event> = map(EventEntity::toDto)
