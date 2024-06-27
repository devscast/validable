package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RegexValidableTest {

    lateinit var validable: RegexValidable

    @BeforeTest
    fun setUp() {
        validable = RegexValidable("^[0-9]+$")
        validable.enableShowErrors()
    }

    @Test
    fun shouldMatch() {
        validable.value = "897"
        assertFalse(validable.hasError())
    }

    @Test
    fun shouldNotMatch() {
        validable.value = "kalume"
        assertTrue(validable.hasError())
    }
}
