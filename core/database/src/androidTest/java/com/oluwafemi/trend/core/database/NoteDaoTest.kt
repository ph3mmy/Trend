package com.oluwafemi.trend.core.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.oluwafemi.trend.core.database.dao.NoteDao
import com.oluwafemi.trend.core.database.entity.NoteEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NoteDaoTest {

    private lateinit var trendDatabase: TrendDatabase
    private lateinit var noteDao: NoteDao


    @Before
    fun createInMemoryDB() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        trendDatabase = Room.inMemoryDatabaseBuilder(
            context = context,
            klass = TrendDatabase::class.java
        ).build()
        noteDao = trendDatabase.noteDao()
    }

    @After
    fun tearDownDB() {
        trendDatabase.close()
    }

    @Test
    fun noteDao_inserts_new_note() = runTest {
        val note = testNote(id = 1)

        noteDao.addNoteEntities(listOf(note))

        assert(noteDao.fetchAllNoteEntities().first().contains(note))
    }

    @Test
    fun noteDao_fetches_new_note_in_descending_date() = runTest {

        noteDao.addNoteEntities(testNotes)

        val sortedNotes = testNotes.sortedByDescending { it.id }

        assertEquals(sortedNotes, noteDao.fetchAllNoteEntities().first())
    }

    @Test
    fun noteDao_fetchNoteById_returns_note() = runTest {

        noteDao.addNoteEntities(testNotes)

        val note4 = noteDao.getNoteEntityById(4).first()

        assertEquals(note4, testNotes[2])
    }

    @Test
    fun noteDao_deletes_note_by_ids() = runTest {

        noteDao.addNoteEntities(testNotes)
        val (toDelete, toKeep) = testNotes.partition { it.id % 2 == 0 }

        noteDao.deleteNoteEntities(toDelete.map { it.id })

        assertEquals(toKeep.map { it.id }.toSet(), noteDao.fetchAllNoteEntities().first().map { it.id }.toSet())
    }

    private val testNotes = listOf(
        testNote(id = 5, dateCreated = 5),
        testNote(id = 1, dateCreated = 1),
        testNote(id = 4, dateCreated = 4),
        testNote(id = 3, dateCreated = 3),
        testNote(id = 2, dateCreated = 2),
    )

    private fun testNote(
        id: Int,
        dateCreated: Long = 0,
        dateModified: Long = 0
    ) = NoteEntity(
        id = id,
        title = "",
        body = "",
        label = "",
        photos = emptySet(),
        tags = emptySet(),
        checklist = emptySet(),
        dateCreated = Instant.fromEpochMilliseconds(dateCreated),
        dateModified = Instant.fromEpochMilliseconds(dateModified)
    )
}