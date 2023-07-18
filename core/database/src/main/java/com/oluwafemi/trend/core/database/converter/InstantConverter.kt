package com.oluwafemi.trend.core.database.converter

import androidx.room.TypeConverter
import kotlinx.datetime.Instant


class InstantConverter {

    @TypeConverter
    fun instantToLongConverter(value: Instant?): Long? {
        return value?.toEpochMilliseconds()
    }

    @TypeConverter
    fun longToInstantConverter(value: Long?): Instant? {
        return value?.let(Instant::fromEpochMilliseconds)
    }
}