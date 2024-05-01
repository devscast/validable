package tech.devscast.validable

/**
 * Validates that a value is not empty - blank strings are valid.
 */
class NotEmptyValidable(message: String? = null) : BaseValidable(
    validator = { value -> value.isNotEmpty() },
    errorFor = { _ ->
        message ?: "This field is required"
    }
)
