package tech.devscast.validable

import java.util.regex.Pattern

/**
 * Validates that a value is a valid email address.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
*/
class EmailValidable(message: String? = null) : BaseValidable(
    validator = { value ->
        Pattern.matches("^[A-Za-z](.*)([@]{1})(.+)(\\.)(.+)", value)
    },
    errorFor = { value ->
        message ?: "$value is not a valid email address."
    }
)
