package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LessThanValidableTest {

    lateinit var validable: LessThanValidable

    @BeforeTest
    fun setUp() {
        validable = LessThanValidable(100)
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
    fun biggerValueHasError() {
        validable.value = "150"
        assertTrue(validable.hasError())
    }

    @Test
    fun limitValueHasError() {
        validable.value = "100"
        assertTrue(validable.hasError())
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun lowerThanLimitValueIsValid() {
        validable.value = "99"
        assertFalse(validable.hasError())

        validable.value = "10"
        assertFalse(validable.hasError())
    }
}
