package com.oluwafemi.trend.core.data.mapper

import com.oluwafemi.trend.core.database.entity.NoteEntity
import com.oluwafemi.trend.core.domain.model.Body
import com.oluwafemi.trend.core.domain.model.ID
import com.oluwafemi.trend.core.domain.model.Label
import com.oluwafemi.trend.core.domain.model.Note
import com.oluwafemi.trend.core.domain.model.Photo
import com.oluwafemi.trend.core.domain.model.Tag
import com.oluwafemi.trend.core.domain.model.Title
import com.oluwafemi.trend.core.domain.model.toChecklist

// Todo: Check best practices around usage of Mappers
fun Note.asEntity() = NoteEntity(
        id = this.id.value,
        title = this.title.value,
        body = this.body.value,
        label = this.label.value,
        photos = this.photos.map { it.value }.toSet(),
        tags = this.tags.map { it.value }.toSet(),
        checklist = this.checklist.map { it.toString() }.toSet(),
        dateCreated = this.dateCreated,
        dateModified = this.dateModified
    )

fun NoteEntity.asNote() = Note(
        id = ID(this.id),
        title = Title(this.title),
        body = Body(this.body),
        photos = this.photos.map { Photo(it) },
        label = Label(this.label),
        tags = this.tags.map { Tag(it) }.toSet(),
        checklist = this.checklist.map { it.toChecklist() }.toSet(),
        dateCreated = this.dateCreated,
        dateModified = this.dateModified
)