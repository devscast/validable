package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NegativeOrZeroValidableTest {

    lateinit var validable: NegativeOrZeroValidable

    @Before
    fun setUp() {
        validable = NegativeOrZeroValidable()
        validable.enableShowErrors()
    }

    @Test
    fun `positive or malformed string number has error`() {
        validable.value = ""
        Assert.assertTrue(validable.hasError())

        validable.value = "9"
        Assert.assertTrue(validable.hasError())

        validable.value = "4-5"
        Assert.assertTrue(validable.errorMessage != null)
    }

    @Test
    fun `negative or zero number is valid`() {
        validable.value = "-23"
        Assert.assertFalse(validable.hasError())

        validable.value = "0"
        Assert.assertFalse(validable.hasError())

        validable.value = "-24.3"
        Assert.assertFalse(validable.hasError())
    }
}
