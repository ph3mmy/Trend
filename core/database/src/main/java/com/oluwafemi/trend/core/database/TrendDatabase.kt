package com.oluwafemi.trend.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.oluwafemi.trend.core.database.converter.CollectionStringConverter
import com.oluwafemi.trend.core.database.converter.InstantConverter
import com.oluwafemi.trend.core.database.dao.NoteDao
import com.oluwafemi.trend.core.database.entity.ChecklistEntity
import com.oluwafemi.trend.core.database.entity.NoteEntity

@Database(
    entities = [NoteEntity::class, ChecklistEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(CollectionStringConverter::class, InstantConverter::class)
abstract class TrendDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}