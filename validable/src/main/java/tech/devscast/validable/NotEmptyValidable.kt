package tech.devscast.validable

/**
 * Validates that a value is not blank - meaning not equal to a blank string.
 */
class NotEmptyValidable(message: String = "") : BaseValidable(
    validator = { value -> value.isNotBlank() },
    errorFor = { _ ->
        message.ifBlank { "This field is required" }
    }
)
