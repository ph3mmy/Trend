package com.oluwafemi.trend.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChecklistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "note_id")
    val noteId: Int,
    val text: String,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean
)
