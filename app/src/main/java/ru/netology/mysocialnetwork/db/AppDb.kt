package ru.netology.mysocialnetwork.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import ru.netology.mysocialnetwork.dao.EventDao
import ru.netology.mysocialnetwork.dao.PostDao
import ru.netology.mysocialnetwork.entity.EventEntity
import ru.netology.mysocialnetwork.entity.PostEntity
import ru.netology.mysocialnetwork.utils.Converters

@Database(entities = [PostEntity::class,EventEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDb :RoomDatabase(){
abstract fun postDao():PostDao
abstract fun eventDao():EventDao



}
