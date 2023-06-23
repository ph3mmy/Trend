package com.oluwafemi.trend.core.domain.model

data class Checklist(
    val id: ID,
    val text: Body,
    val isCompleted: Boolean
)
