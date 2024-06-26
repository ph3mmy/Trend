package com.oluwafemi.trend.core.domain.repository

import com.oluwafemi.trend.core.domain.model.ID
import com.oluwafemi.trend.core.domain.model.Note

import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    /**
     * creates a [Note] item and insert into storage
     */
    suspend fun createNote(note: Note)

    /**
     * Update [Note] with new fields
     */
    suspend fun updateNote(note: Note)

    /**
     * Delete notes by the given note [ID]s
     */
    suspend fun deleteNotes(noteIds: List<ID>)

    /**
     * Returns a list of all notes
     */
    fun fetchNotes(): Flow<List<Note>>

    /**
     * Get a particular [Note] by [ID]
     */
    fun fetchNoteById(noteId: ID): Flow<Note>

}
