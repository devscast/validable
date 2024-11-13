package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PositiveOrZeroValidableTest {

    lateinit var validable: PositiveOrZeroValidable

    @BeforeTest
    fun setUp() {
        validable = PositiveOrZeroValidable()
        validable.enableShowErrors()
    }

    @Test
    fun negativeOrMalformedStringNumberHasError() {
        validable.value = ""
        assertTrue(validable.hasError())

        validable.value = "-9"
        assertTrue(validable.hasError())

        validable.value = "4-5"
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun positiveNumberOrZeroIsValid() {
        validable.value = "23"
        assertFalse(validable.hasError())

        validable.value = "0"
        assertFalse(validable.hasError())

        validable.value = "24.3"
        assertFalse(validable.hasError())
    }
}
