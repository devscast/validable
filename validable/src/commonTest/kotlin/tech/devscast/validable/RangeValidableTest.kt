package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RangeValidableTest {

    lateinit var validable: RangeValidable

    @BeforeTest
    fun setUp() {
        validable = RangeValidable(minValue = 20, maxValue = 40)
        validable.enableShowErrors()
    }

    @Test
    fun malformedStringNumberHasError() {
        validable.value = "hello"
        assertTrue(validable.hasError())

        validable.value = "#9"
        assertTrue(validable.hasError())

        validable.value = "4-5"
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun inclusiveRangeIsValid() {
        validable.value = "23"
        assertFalse(validable.hasError())

        // TODO: handle floats
        validable.value = "39"
        assertFalse(validable.hasError())
    }

    @Test
    fun exclusiveRangeHasError() {
        validable.value = "19"
        assertTrue(validable.hasError())

        validable.value = "41"
        assertTrue(validable.hasError())
    }
}
