package tech.devscast.validable

import java.util.regex.Pattern

/**
 * Validates that a value is a valid email address.
 */
class EmailValidable(message: String = "") : BaseValidable(
    validator = { value ->
        Pattern.matches("^[A-Za-z](.*)([@]{1})(.+)(\\.)(.+)", value)
    },
    errorFor = { value ->
        message.ifBlank { "$value is not a valid email address." }
    }
)
