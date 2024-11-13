package tech.devscast.validable

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class NotBlankValidableTest {
    lateinit var validable: NotBlankValidable

    @BeforeTest
    fun setUp() {
        validable = NotBlankValidable()
        validable.enableShowErrors()
    }

    @Test
    fun emptyOrBlankTextHasError() {
        validable.value = ""
        assertTrue(validable.hasError(),"empty or blank text has error")

        validable.value = "  "
        assertTrue(validable.hasError(),"blank text has error")
        assertTrue(validable.errorMessage != null)
    }

    @Test
    fun notBlankTextIsValid() {
        validable.value = "Hello world"
        assertTrue(validable.isValid,"Not blank text is valid")
        assertTrue(validable.errorMessage == null,"Not blank text does not have error")
    }
}
