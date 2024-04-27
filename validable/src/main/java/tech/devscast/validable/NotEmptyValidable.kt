package tech.devscast.validable

/**
 * Validates that a value is not empty and contains some characters or whitespace characters.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 */
class NotEmptyValidable(message: String? = null) : BaseValidable(
    validator = { value -> value.isNotBlank() },
    errorFor = { _ ->
        message ?: "This field is required"
    }
)
