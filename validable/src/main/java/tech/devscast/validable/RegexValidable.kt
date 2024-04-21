package tech.devscast.validable

import java.util.regex.Pattern

/**
 * Validates that a value matches a regular expression.
 */
class RegexValidable(pattern: String, message: String = "") : BaseValidable(
    validator = { value -> Pattern.matches(pattern, value) },
    errorFor = { _ -> message.ifBlank { "This value is not valid." } }
)
