package com.oluwafemi.trend.core.domain.model

import kotlinx.datetime.Instant
import org.junit.Assert.assertThrows
import org.junit.Test

internal class NoteTest {

    private val note = Note(
        id = ID(1),
        title = Title("Test Note"),
        body = Body("This is a test note"),
        photos = List(10) {index -> Photo("$index") },
        label = Label("Test label"),
        tags = emptySet(),
        checklist = emptySet(),
        dateCreated = Instant.DISTANT_PAST,
        dateModified = Instant.DISTANT_PAST
    )

    @Test
    fun `throws no exception when less than 10 photos are attached to a note`() {
        val noteWithLessPhoto = note.copy(photos = List(8) {index -> Photo("$index") })
    }

    @Test
    fun `throws no exception when exactly 10 photos are attached to a note`() {
        val noteWithLessPhoto = note.copy(photos = List(10) {index -> Photo("$index") })
    }

    @Test
    fun `throw exception when more than 10 photos are attached to a note`() {
        assertThrows(IllegalArgumentException::class.java) {
            val noteWithExcessPhoto = note.copy(photos = List(12) {index -> Photo("$index") })
        }
    }

}