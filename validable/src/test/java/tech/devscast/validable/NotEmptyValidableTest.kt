package tech.devscast.validable

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NotEmptyValidableTest {

    lateinit var validable: NotEmptyValidable

    @Before
    fun setUp() {
        validable = NotEmptyValidable()
        validable.enableShowErrors()
    }

    @Test
    fun `empty text has error`() {
        validable.value = ""
        assertTrue("Empty string must have error", validable.hasError())
        assertTrue("Empty string must have error message", validable.errorMessage != null)
        assertFalse("Empty string must not be valid", validable.isValid)
    }

    @Test
    fun `blank string is valid`() {
        validable.value = "  "
        assertTrue("Blank string must be valid", validable.isValid)
        assertFalse("Blank string must not have error", validable.hasError())
    }

    @Test
    fun `not empty text is valid`() {
        validable.value = "Hello world"
        assertTrue("Not empty string must be valid",validable.isValid)
        assertTrue("Not empty string must not have error",validable.errorMessage == null)
    }
}
