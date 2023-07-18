package com.oluwafemi.trend.core.database.converter

import kotlinx.datetime.Instant
import org.junit.Assert.assertEquals
import org.junit.Test

class InstantConverterTest {

    private val instant = Instant.parse("2023-07-18T16:03:06.720Z")
    private val timeInMillis = 1689696186720

    private val sut = InstantConverter()

    @Test
    fun `Return Instant time when given a timeStamp in milliseconds`() {

        val result = sut.longToInstantConverter(timeInMillis)

        assertEquals(instant, result)
    }

    @Test
    fun `Return timeStamp in milliseconds when given an Instant type`() {

        val result = sut.instantToLongConverter(instant)

        assertEquals(timeInMillis, result)
    }
}