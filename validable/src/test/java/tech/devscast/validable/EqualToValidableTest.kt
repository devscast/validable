package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class EqualToValidableTest {

    lateinit var validable: EqualToValidable

    @Before
    fun setUp() {
        validable = EqualToValidable("someString")
        validable.enableShowErrors()
    }

    @Test
    fun `exact string is valid`() {
        validable.value = "someString"
        Assert.assertFalse(validable.hasError())
        Assert.assertFalse(validable.errorMessage != null)
    }

    @Test
    fun `different string has error`() {
        validable.value = "otherString"
        Assert.assertTrue(validable.hasError())

        validable.value = "440"
        Assert.assertTrue(validable.hasError())
    }
}
