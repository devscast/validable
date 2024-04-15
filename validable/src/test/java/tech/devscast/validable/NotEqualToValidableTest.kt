package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NotEqualToValidableTest {

    lateinit var validable: NotEqualToValidable

    @Before
    fun setUp() {
        validable = NotEqualToValidable("someString")
        validable.enableShowErrors()
    }

    @Test
    fun `exact string has error`() {
        validable.value = "someString"
        Assert.assertTrue(validable.hasError())
        Assert.assertTrue(validable.errorMessage != null)
    }

    @Test
    fun `different string is valid`() {
        validable.value = "otherString"
        Assert.assertFalse(validable.hasError())

        validable.value = "440"
        Assert.assertFalse(validable.hasError())
    }
}
