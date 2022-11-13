package tech.devscast.validable

class EmailValidable : BaseValidable(validator = ::isEmailValid, errorFor = ::emailValidationError)

private fun isEmailValid(email: String): Boolean {
	return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun emailValidationError(email: String): String {
	return "Invalid email: $email"
}