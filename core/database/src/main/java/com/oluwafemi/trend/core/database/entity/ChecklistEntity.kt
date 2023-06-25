package com.oluwafemi.trend.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class ChecklistEntity(
    val id: Int,
    @ColumnInfo(name = "note_id")
    val noteId: Int,
    val text: String,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean
)
