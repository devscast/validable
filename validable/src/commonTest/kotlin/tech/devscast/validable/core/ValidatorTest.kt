package tech.devscast.validable.core


import tech.devscast.validable.EmailValidable
import tech.devscast.validable.EqualToValidable
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidatorTest {

    @Test
    fun testValidatorWhenInputAreNotValid() {
        val validable1 = EmailValidable()
        validable1.value = "example"
        val validable2 = EqualToValidable("Hello world")
        validable2.value = "Hello"
        val validator = Validator(validable1, validable2)
        var isValid = false
        validator.validate {
            isValid = true
        }
        assertFalse(isValid,"Should be false")
    }

    @Test

    fun testValidatorWhenInputAreValid() {
        val validable1 = EmailValidable()
        validable1.value = "example@gmail.com"
        val validable2 = EqualToValidable("Hello world")
        validable2.value = "Hello world"
        val validator = Validator(validable1, validable2)
        var isValid = false
        validator.validate {
            isValid = true
        }
        assertTrue(isValid,"Should be true")
    }
}
