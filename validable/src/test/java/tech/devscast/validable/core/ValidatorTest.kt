package tech.devscast.validable.core

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import tech.devscast.validable.EmailValidable
import tech.devscast.validable.EqualToValidable

class ValidatorTest {

    @Test
    fun `test validator when input are not valid`(){
        val validable1 = EmailValidable()
        validable1.value = "example"
        val validable2 = EqualToValidable("Hello world")
        validable2.value = "Hello"
        val validator = Validator(validable1,validable2)
        var isValid = false
        validator.validate {
            isValid = true
        }
        assertFalse("Should be false",isValid)
    }

    @Test

    fun `test validator when input are valid`(){
        val validable1 = EmailValidable()
        validable1.value = "example@gmail.com"
        val validable2 = EqualToValidable("Hello world")
        validable2.value = "Hello world"
        val validator = Validator(validable1,validable2)
        var isValid = false
        validator.validate {
            isValid = true
        }
        assertTrue("Should be true",isValid)
    }
}
