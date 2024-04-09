package com.oluwafemi.trend.core.data

import com.oluwafemi.trend.core.data.mapper.asEntity
import com.oluwafemi.trend.core.data.mapper.asNote
import com.oluwafemi.trend.core.database.entity.NoteEntity
import com.oluwafemi.trend.core.domain.model.Body
import com.oluwafemi.trend.core.domain.model.Checklist
import com.oluwafemi.trend.core.domain.model.ID
import com.oluwafemi.trend.core.domain.model.Label
import com.oluwafemi.trend.core.domain.model.Note
import com.oluwafemi.trend.core.domain.model.Photo
import com.oluwafemi.trend.core.domain.model.Tag
import com.oluwafemi.trend.core.domain.model.Title
import kotlinx.datetime.Instant
import org.junit.Test
import kotlin.test.assertEquals

class NoteMapperTest {

    private val testChecklist =
        Checklist(id = ID(1), text = Body("Checklist Body"), isCompleted = false)

    @Test
    fun `Domain note can be mapped as noteEntity`() {
        val domainNote = Note(
            id = ID(1),
            title = Title("Test Title"),
            body = Body("Test Body"),
            photos = listOf(Photo("Test Photo")),
            label = Label("Test Label"),
            tags = setOf(Tag("Test Tag")),
            checklist = setOf(testChecklist),
            dateCreated = Instant.fromEpochSeconds(1),
            dateModified = Instant.fromEpochSeconds(2)
        )

        val entity = domainNote.asEntity()

        assertEquals(expected = domainNote.id.value, actual = entity.id)
        assertEquals(expected = domainNote.body.value, actual = entity.body)
        assertEquals(expected = domainNote.title.value, actual = entity.title)
        assertEquals(expected = domainNote.photos.first().value, actual = entity.photos.first())
        assertEquals(expected = domainNote.label.value, actual = entity.label)
        assertEquals(expected = domainNote.tags.first().value, actual = entity.tags.first())
        assertEquals(
            expected = domainNote.checklist.first().toString(),
            actual = entity.checklist.first()
        )
        assertEquals(expected = domainNote.dateCreated, actual = entity.dateCreated)
        assertEquals(expected = domainNote.dateModified, actual = entity.dateModified)
    }

    @Test
    fun `NoteEntity can be mapped to Domain note`() {
        val noteEntity = NoteEntity(
            id = 1,
            title = "Test Title",
            body = "Test Body",
            label = "Test Label",
            photos = setOf("Test Photo"),
            tags = setOf("Test Tag"),
            checklist = setOf(testChecklist.toString()),
            dateCreated = Instant.fromEpochSeconds(1),
            dateModified = Instant.fromEpochSeconds(2)
        )

        val domainNote = noteEntity.asNote()

        assertEquals(expected = noteEntity.id, actual = domainNote.id.value)
        assertEquals(expected = noteEntity.title, actual = domainNote.title.value)
        assertEquals(expected = noteEntity.body, actual = domainNote.body.value)
        assertEquals(expected = noteEntity.label, actual = domainNote.label.value)
        assertEquals(expected = noteEntity.photos.first(), actual = domainNote.photos.first().value)
        assertEquals(expected = noteEntity.tags.first(), actual = domainNote.tags.first().value)
        assertEquals(expected = noteEntity.checklist.first(), actual = domainNote.checklist.first().toString())
        assertEquals(expected = noteEntity.dateCreated, actual = domainNote.dateCreated)
        assertEquals(expected = noteEntity.dateModified, actual = domainNote.dateModified)
    }

}