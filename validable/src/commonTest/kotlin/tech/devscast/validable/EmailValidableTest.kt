package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EmailValidableTest {

    lateinit var validable: EmailValidable

    @BeforeTest
    fun setUp() {
        validable = EmailValidable()
        validable.enableShowErrors()
    }

    @Test
    fun badEmailHasError() {
        validable.value = "devscast"
        assertTrue(validable.hasError())

        validable.value = "devscast@"
        assertTrue(validable.hasError())

        validable.value = "devscast@gmail"
        assertTrue(validable.hasError())

        validable.value = "devscast@gmail."
        assertTrue(validable.hasError())

        validable.value = "@gmail.com"
        assertTrue(validable.hasError())
    }

    @Test
    fun badEmailReturnsErrorMessage() {
        validable.value = "devscast"
        assertFalse(validable.errorMessage == null)
    }

    @Test
    fun correctEmailIsValid() {
        validable.value = "devscast@gmail.com"
        assertTrue(validable.isValid)

        validable.value = "devscast"
        validable.value = "devscast@gmail.com"
        assertTrue(validable.isValid)
    }
}
