package tech.devscast.validable

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NotBlankValidableTest {
    lateinit var validable: NotBlankValidable

    @Before
    fun setUp() {
        validable = NotBlankValidable()
        validable.enableShowErrors()
    }

    @Test
    fun `empty or blank text has error`() {
        validable.value = ""
        assertTrue("empty or blank text has error", validable.hasError())

        validable.value = "  "
        assertTrue("blank text has error", validable.hasError())
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun `not blank text is valid`() {
        validable.value = "Hello world"
        assertTrue("Not blank text is valid", validable.isValid)
        assertTrue("Not blank text does not have error", validable.errorMessage == null)
    }
}
