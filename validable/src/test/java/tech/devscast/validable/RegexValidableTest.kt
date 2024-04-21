package tech.devscast.validable

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RegexValidableTest {

    lateinit var validable: RegexValidable

    @Before
    fun setUp() {
        validable = RegexValidable("^[0-9]+$")
        validable.enableShowErrors()
    }

    @Test
    fun `should match`() {
        validable.value = "897"
        Assert.assertFalse(validable.hasError())
    }

    @Test
    fun `should not match`() {
        validable.value = "kalume"
        Assert.assertTrue(validable.hasError())
    }
}
