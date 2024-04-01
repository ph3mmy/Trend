package com.oluwafemi.trend.core.domain.model

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class ID (val value: Int)

@JvmInline
value class Title(val value: String)

@Serializable
@JvmInline
value class Body(val value: String)

@JvmInline
value class Photo(val value: String)

@JvmInline
value class Label(val value: String)

@JvmInline
value class Tag(val value: String)
