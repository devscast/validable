package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PositiveValidableTest {

    lateinit var validable: PositiveValidable

    @BeforeTest
    fun setUp() {
        validable = PositiveValidable()
        validable.enableShowErrors()
    }

    @Test
    fun zeroIsNeitherPositiveNorNegative() {
        validable.value = "0"
        assertTrue(validable.hasError())
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
    fun positiveNumberIsValid() {
        validable.value = "23"
        assertFalse(validable.hasError())

        validable.value = "24.3"
        assertFalse(validable.hasError())
    }
}
