package com.oluwafemi.trend.core.data.repository

import com.oluwafemi.trend.core.data.mapper.asEntity
import com.oluwafemi.trend.core.data.mapper.asNote
import com.oluwafemi.trend.core.database.dao.NoteDao
import com.oluwafemi.trend.core.domain.model.ID
import com.oluwafemi.trend.core.domain.model.Note
import com.oluwafemi.trend.core.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultNoteRepository @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository {
    override suspend fun createNote(note: Note) {
        noteDao.addNoteEntity(note.asEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.addNoteEntity(note.asEntity())
    }

    override suspend fun deleteNotes(noteIds: List<ID>) {
        noteDao.deleteNoteEntities(noteIds.map { it.value })
    }

    override fun fetchNotes(): Flow<List<Note>> {
        return noteDao.fetchAllNoteEntities().map { it.map { noteEntity -> noteEntity.asNote() } }
    }

    override fun fetchNoteById(noteId: ID): Flow<Note> {
        return noteDao.getNoteEntityById(noteId.value).map { it.asNote() }
    }
}