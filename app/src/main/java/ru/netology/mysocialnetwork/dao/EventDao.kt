package ru.netology.mysocialnetwork.dao



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.netology.mysocialnetwork.entity.EventEntity
import ru.netology.mysocialnetwork.entity.PostEntity


@Dao
interface EventDao {
    suspend fun save(event: EventEntity) =
        if (event.id == 0L) insert(event) else updateContentById(event.id, event.content)

    @Query("SELECT * FROM EventEntity WHERE id = :eventId")
    suspend fun getById(eventId: Long): EventEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: EventEntity)

    @Query("UPDATE EventEntity SET content = :content WHERE id = :id")
    suspend fun updateContentById(id: Long, content: String)
}
