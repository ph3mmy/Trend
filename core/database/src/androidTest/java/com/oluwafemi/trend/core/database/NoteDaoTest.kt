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
    fun noteDao_inserts_new_note () = runTest {
        val note = testNote(id = 1)

        noteDao.addNoteEntity(note)

        assert(noteDao.fetchAllNoteEntities().first().contains(note))
    }


    // Todo: Add more tests

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