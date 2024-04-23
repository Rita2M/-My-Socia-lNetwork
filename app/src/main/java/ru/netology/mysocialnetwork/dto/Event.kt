package ru.netology.mysocialnetwork.dto

data class Event(
    val id: Long,
    val authorId: Long,
    val author: String,
    val authorJob: String? = null,
    val authorAvatar: String? = null,
    val content: String,
    val datetime: String, // string($data-time
    val published: String, // string($data-time
    val type: Type = Type.ONLINE, // enum online offline
    val likeOwnerIds: List<Long>, // error  uniqueItems: true
    val likedByMe: Boolean,
    val attachment: Attachment? = null,
    val participantsIds: List<Long>, //Error  uniqueItems: true
    val participatedByMe: Boolean,
    val coords: Coordinates?=null,
    val link: String? = null,
    val speakerIds: List<Long>, // Error 	 uniqueItems: true
    val users: Map<String, UserPreview>,


    ) {

}


data class Coordinates(
    val lat: Double,
    val long: Double,
)

data class UserPreview(
    val name: String,
    val avatar: String,
)
