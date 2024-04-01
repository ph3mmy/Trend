package com.oluwafemi.trend.core.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Checklist(
    val id: ID,
    val text: Body,
    val isCompleted: Boolean
) {
    // Todo: Get rid of Serializable annotation as domain models should be pure data classes
    // Todo: Add unit test
    // Todo: Check if there is any value in usage of DDD Value classes
    // Todo: Convert Checklist to a separate table
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

fun String.toChecklist() = Json.decodeFromString<Checklist>(this)
