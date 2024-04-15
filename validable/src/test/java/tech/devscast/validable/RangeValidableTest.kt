package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RangeValidableTest {

    lateinit var validable: RangeValidable

    @Before
    fun setUp() {
        validable = RangeValidable(minValue = 20, maxValue = 40)
        validable.enableShowErrors()
    }

    @Test
    fun `malformed string number has error`() {
        validable.value = "hello"
        Assert.assertTrue(validable.hasError())

        validable.value = "#9"
        Assert.assertTrue(validable.hasError())

        validable.value = "4-5"
        Assert.assertTrue(validable.errorMessage != null)
    }

    @Test
    fun `inclusive range is valid`() {
        validable.value = "23"
        Assert.assertFalse(validable.hasError())

        validable.value = "24.3"
        Assert.assertFalse(validable.hasError())
    }

    @Test
    fun `exclusive range has error`() {
        validable.value = "19"
        Assert.assertTrue(validable.hasError())

        validable.value = "41"
        Assert.assertTrue(validable.hasError())
    }
}
