package tech.devscast.validable

/**
 * Validates that a value is not blank - meaning not equal to a blank string.
 */
class NotEmptyValidable(message: String? = null) : BaseValidable(
    validator = { value -> value.isNotBlank() },
    errorFor = { _ ->
        message ?: "This field is required"
    }
)
