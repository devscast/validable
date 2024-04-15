package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LessThanOrEqualValidableTest {

    lateinit var validable: LessThanOrEqualValidable

    @Before
    fun setUp() {
        validable = LessThanOrEqualValidable(100)
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
    fun `bigger value has error`() {
        validable.value = "150"
        Assert.assertTrue(validable.hasError())
    }

    @Test
    fun `limit value is valid`() {
        validable.value = "100"
        Assert.assertFalse(validable.hasError())
        Assert.assertFalse(validable.errorMessage != null)
    }

    @Test
    fun `lower than limit value is valid`() {
        validable.value = "99"
        Assert.assertFalse(validable.hasError())

        validable.value = "10"
        Assert.assertFalse(validable.hasError())
    }
}
