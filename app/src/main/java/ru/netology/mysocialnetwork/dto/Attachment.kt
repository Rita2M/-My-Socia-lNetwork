package ru.netology.mysocialnetwork.dto

enum class AttachmentType {
    IMAGE, VIDEO, AUDIO
}
data class Attachment(
    val url: String,
    val type: AttachmentType,
)
