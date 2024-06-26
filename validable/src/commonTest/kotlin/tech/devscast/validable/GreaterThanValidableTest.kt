package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GreaterThanValidableTest {

    lateinit var validable: GreaterThanValidable

    @Before
    fun setUp() {
        validable = GreaterThanValidable(100)
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
    fun `bigger value is valid`() {
        validable.value = "150"
        Assert.assertFalse(validable.hasError())
    }

    @Test
    fun `limit value has error`() {
        validable.value = "100"
        Assert.assertTrue(validable.hasError())
        Assert.assertTrue(validable.errorMessage != null)
    }

    @Test
    fun `lower than limit value has error`() {
        validable.value = "99"
        Assert.assertTrue(validable.hasError())

        validable.value = "10"
        Assert.assertTrue(validable.hasError())
    }
}
