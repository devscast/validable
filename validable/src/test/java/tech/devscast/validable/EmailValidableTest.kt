package tech.devscast.validable

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EmailValidableTest {

	lateinit var validable: EmailValidable

	@Before
	fun setUp() {
		validable = EmailValidable()
		validable.enableShowErrors()
	}

	@Test
	fun `bad email has error`() {
		validable.value = "devscast"
		assertTrue(validable.hasError())

		validable.value = "devscast@"
		assertTrue(validable.hasError())

		validable.value = "devscast@gmail"
		assertTrue(validable.hasError())

		validable.value = "devscast@gmail."
		assertTrue(validable.hasError())

		validable.value = "@gmail.com"
		assertTrue(validable.hasError())
	}

	@Test
	fun `bad email returns errorMessage`() {
		validable.value = "devscast"
		assertFalse(validable.errorMessage == null)
	}

	@Test
	fun `correct email is valid`() {
		validable.value = "devscast@gmail.com"
		assertTrue(validable.isValid)

		validable.value = "devscast"
		validable.value = "devscast@gmail.com"
		assertTrue(validable.isValid)
	}

}