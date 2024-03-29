package com.oluwafemi.trend.core.domain.model

import kotlinx.datetime.Instant

data class Note(
    val id: ID,
    val title: Title,
    val body: Body,
    val photos: List<Photo>,
    val label: Label,
    val tags: Set<Tag>,
    val checklist: Set<Checklist>,
    val dateCreated: Instant,
    val dateModified: Instant
) {
    init { // TODO: read up DDD and add tests to models
        require(photos.size <= MAX_ALLOWED_PHOTOS) {
            "Only a maximum of 10 photos can be attached"
        }
    }

    companion object {
        const val MAX_ALLOWED_PHOTOS = 10
    }
}
