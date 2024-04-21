package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PositiveValidableTest {

    lateinit var validable: PositiveValidable

    @Before
    fun setUp() {
        validable = PositiveValidable()
        validable.enableShowErrors()
    }

    @Test
    fun `zero is neither positive nor negative`() {
        validable.value = "0"
        Assert.assertTrue(validable.hasError())
    }

    @Test
    fun `negative or malformed string number has error`() {
        validable.value = ""
        Assert.assertTrue(validable.hasError())

        validable.value = "-9"
        Assert.assertTrue(validable.hasError())

        validable.value = "4-5"
        Assert.assertTrue(validable.errorMessage != null)
    }

    @Test
    fun `positive number is valid`() {
        validable.value = "23"
        Assert.assertFalse(validable.hasError())

        validable.value = "24.3"
        Assert.assertFalse(validable.hasError())
    }
}
