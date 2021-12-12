package tech.devscast.validable

import java.util.regex.Pattern

class EmailValidable : BaseValidable(validator = ::isEmailValid, errorFor = ::emailValidationError)

private fun isEmailValid(email: String): Boolean {
    return Pattern.matches("^(.+)@(.+)\$", email)
}

/**
 * Returns an error to be displayed or null if no error was found
 */
private fun emailValidationError(email: String): String {
    return "Invalid email: $email"
}