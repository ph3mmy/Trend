package com.oluwafemi.trend.core.database.converter

import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionStringConverterTest {

    private val stringSet = setOf("Photo 1", "Photo 2", "Photo 3")
    private val jsonStringArray = """["Photo 1","Photo 2","Photo 3"]""".trim()

    private val sut = CollectionStringConverter()

    @Test
    fun `Return json array of string when given a Set of strings`() {

        val result = sut.setToStringConverter(stringSet)

        val expected = jsonStringArray

        assertEquals(expected, result)
    }

    @Test
    fun `Return set of strings when given a json array of strings`() {

        val result = sut.stringToSetConverter(jsonStringArray)

        val expected = stringSet

        assertEquals(expected, result)
    }

}