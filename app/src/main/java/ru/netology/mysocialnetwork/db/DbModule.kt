package ru.netology.mysocialnetwork.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.netology.mysocialnetwork.dao.EventDao
import ru.netology.mysocialnetwork.dao.PostDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DbModule {

    @Singleton
    @Provides
    fun providesDb(
        @ApplicationContext
        context: Context
    ): AppDb = Room.databaseBuilder(context, AppDb::class.java, "app.db")
        .fallbackToDestructiveMigration()
        .build()
    @Provides
    fun providePostDao(
        appDb: AppDb
    ): PostDao = appDb.postDao()
    @Provides
    fun provideEventDao(
        appDb: AppDb
    ):EventDao =appDb.eventDao()
}
