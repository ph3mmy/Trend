package com.oluwafemi.trend.core.model

import kotlinx.datetime.Instant

data class Note(
    val id: ID,
    val title: Title,
    val body: Body,
    val photos: List<Photo>,
    val label: Label,
    val tag: List<Tag>,
    val dateCreated: Instant,
    val dateModified: Instant
) {
    init {
        check(photos.size <= MAX_ALLOWED_PHOTOS)
    }

    companion object {
        const val MAX_ALLOWED_PHOTOS = 10
    }
}
