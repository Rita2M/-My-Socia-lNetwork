package ru.netology.mysocialnetwork.dto

data class Post(
    val id: Long,
    val authorId: Long,
    val author: String,
    val authorJob: String? = null,
    val authorAvatar: String? = null,
    val content: String,
    val published: String, // string($data-time
    val coords: Coordinates?=null,
    val link: String? = null,
    val mentionIds: List<Long>,
    val mentionedMe: Boolean,
    val likeOwnerIds: List<Long>, // error  uniqueItems: true
    val likedByMe: Boolean,
    val users: Map<String, UserPreview>,

)
