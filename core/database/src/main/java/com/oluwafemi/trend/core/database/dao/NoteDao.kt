package com.oluwafemi.trend.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.oluwafemi.trend.core.database.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM NoteEntity ORDER BY date_created DESC")
    fun fetchAllNoteEntities(): Flow<List<NoteEntity>>

    @Upsert
    suspend fun addNoteEntities(noteEntities: List<NoteEntity>)

    @Query(
        value = """
        SELECT * FROM NoteEntity
        WHERE id = :noteId
    """,
    )
    fun getNoteEntityById(noteId: Int): Flow<NoteEntity>

    @Query(
        value = """
            DELETE FROM NoteEntity
            WHERE id in (:noteIds)
        """
    )
    suspend fun deleteNoteEntities(noteIds: List<Int>)

}