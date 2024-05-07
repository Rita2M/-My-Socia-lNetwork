package ru.netology.mysocialnetwork.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.netology.mysocialnetwork.dto.TypeEvent
import ru.netology.mysocialnetwork.dto.UserPreview


object Converters {
    @TypeConverter

    fun fromSetLong(set: Set<Long>): String {
        return set.joinToString(",")
    }

    @TypeConverter
    fun toSetLong(data: String): Set<Long> {
        return data.split(",").map { it.toLong() }.toSet()
    }
    @TypeConverter
    fun fromUserMap(users: Map<Long, UserPreview>): String {
        return  users.keys.joinToString(",")

    }

    @TypeConverter
    fun toUserMap(usersJson: String): Map<Long, UserPreview> {
        val keysSet = toSetLong(usersJson)
        return keysSet.associateWith { UserPreview("Unknown", "default_avatar_url") } // Здесь нужно использовать вашу логику создания объекта UserPreview
    }
//    @TypeConverter
//
//    fun fromTypeEvent(typeEvent: TypeEvent): String {
//        return typeEvent.name // Преобразование перечисления в его строковое представление
//    }
//
//    @TypeConverter
//    fun toTypeEvent(value: String): TypeEvent {
//        return enumValueOf<TypeEvent>(value) // Преобразование строки обратно в перечисление
//    }
}
