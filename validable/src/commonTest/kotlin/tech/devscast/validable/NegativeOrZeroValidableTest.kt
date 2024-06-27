package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NegativeOrZeroValidableTest {

    lateinit var validable: NegativeOrZeroValidable

    @BeforeTest
    fun setUp() {
        validable = NegativeOrZeroValidable()
        validable.enableShowErrors()
    }

    @Test
    fun positiveOrMalformedStringNumberHasError() {
        validable.value = ""
        assertTrue(validable.hasError())

        validable.value = "9"
        assertTrue(validable.hasError())

        validable.value = "4-5"
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun negativeOrZeroNumberIsValid() {
        validable.value = "-23"
        assertFalse(validable.hasError())

        validable.value = "0"
        assertFalse(validable.hasError())

        validable.value = "-24.3"
        assertFalse(validable.hasError())
    }
}
