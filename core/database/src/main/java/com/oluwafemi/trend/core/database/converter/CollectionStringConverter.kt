package com.oluwafemi.trend.core.database.converter

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CollectionStringConverter {

    @TypeConverter
    fun setToStringConverter(value: Set<String>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun stringToSetConverter(value: String): Set<String> {
        return Json.decodeFromString(value)
    }
}
