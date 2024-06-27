package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EqualToValidableTest {

    lateinit var validable: EqualToValidable

    @BeforeTest
    fun setUp() {
        validable = EqualToValidable("someString")
        validable.enableShowErrors()
    }

    @Test
    fun exactStringIsValid() {
        validable.value = "someString"
        assertFalse(validable.hasError())
        assertFalse(validable.errorMessage != null)
    }

    @Test
    fun differentStringHasError() {
        validable.value = "otherString"
        assertTrue(validable.hasError())

        validable.value = "440"
        assertTrue(validable.hasError())
    }
}
