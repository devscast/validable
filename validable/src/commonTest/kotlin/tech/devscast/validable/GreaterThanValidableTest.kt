package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GreaterThanValidableTest {

    lateinit var validable: GreaterThanValidable

    @BeforeTest
    fun setUp() {
        validable = GreaterThanValidable(100)
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
    fun biggerValueIsValid() {
        validable.value = "150"
        assertFalse(validable.hasError())
    }

    @Test
    fun limitValueHasError() {
        validable.value = "100"
        assertTrue(validable.hasError())
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun lowerThanLimitValueHasError() {
        validable.value = "99"
        assertTrue(validable.hasError())

        validable.value = "10"
        assertTrue(validable.hasError())
    }
}
