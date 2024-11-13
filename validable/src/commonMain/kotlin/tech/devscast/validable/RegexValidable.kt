package tech.devscast.validable

import tech.devscast.validable.util.matches

/**
 * Validates that a value matches a regular expression.
 *
 * @param pattern
 * The regular expression pattern to match against.
 * @param message
 * (Optional) Custom error message for validation failure.
 */
class RegexValidable(pattern: String, message: String? = null) : BaseValidable(
    validator = { value -> matches(pattern, value) },
    errorFor = { _ -> message ?: "This value is not a valid regex." }
)
