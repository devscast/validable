package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NotEqualToValidableTest {

    lateinit var validable: NotEqualToValidable

    @BeforeTest
    fun setUp() {
        validable = NotEqualToValidable("someString")
        validable.enableShowErrors()
    }

    @Test
    fun exactStringHasError() {
        validable.value = "someString"
        assertTrue(validable.hasError())
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun differentStringIsValid() {
        validable.value = "otherString"
        assertFalse(validable.hasError())

        validable.value = "440"
        assertFalse(validable.hasError())
    }
}
