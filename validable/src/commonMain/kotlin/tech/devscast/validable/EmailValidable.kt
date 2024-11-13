package tech.devscast.validable

import tech.devscast.validable.util.matches

/**
 * Validates that a value is a valid email address.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 */
class EmailValidable(message: String? = null) : BaseValidable(
    validator = { value -> matches("^[A-Za-z](.*)([@]{1})(.+)(\\.)(.+)", value) },
    errorFor = { value ->
        message ?: "$value is not a valid email address."
    }
)
