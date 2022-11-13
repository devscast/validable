package tech.devscast.validable

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NotEmptyValidableTest {

	lateinit var validable: NotEmptyValidable

	@Before
	fun setUp() {
		validable = NotEmptyValidable()
		validable.enableShowErrors()
	}

	@Test
	fun `empty or blank text has error`() {
		validable.value = ""
		assertTrue(validable.hasError())

		validable.value = "  "
		assertTrue(validable.hasError())

		assertTrue(validable.errorMessage != null)
	}


	@Test
	fun `not empty text is valid`() {
		validable.value = "Hello world"
		assertTrue(validable.isValid)
		assertTrue(validable.errorMessage == null)
	}
}