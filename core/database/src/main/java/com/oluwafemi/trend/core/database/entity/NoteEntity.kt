package com.oluwafemi.trend.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val body: String,
    val label: String,
    val photos: Set<String>,
    val tags: Set<String>,
    val checklist: Set<String>,
    @ColumnInfo("date_created")
    val dateCreated: Instant,
    @ColumnInfo("date_modified")
    val dateModified: Instant
    )