package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class NotEmptyValidableTest {

    lateinit var validable: NotEmptyValidable

    @BeforeTest
    fun setUp() {
        validable = NotEmptyValidable()
        validable.enableShowErrors()
    }

    @Test
    fun emptyTextHasError() {
        validable.value = ""
        assertTrue(validable.hasError(), "Empty string must have error")
        assertTrue(validable.errorMessage != null, "Empty string must have error message")
        assertFalse(validable.isValid, "Empty string must not be valid")
    }

    @Test
    fun blankStringIsValid() {
        validable.value = "  "
        assertTrue(validable.isValid, "Blank string must be valid")
        assertFalse(validable.hasError(), "Blank string must not have error")
    }

    @Test
    fun notEmptyTextIsValid() {
        validable.value = "Hello world"
        assertTrue(validable.isValid, "Not empty string must be valid")
        assertTrue(validable.errorMessage == null, "Not empty string must not have error")
    }
}
