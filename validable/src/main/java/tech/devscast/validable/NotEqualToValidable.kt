package tech.devscast.validable

/**
 * Validates that a value is not equal to another value,
 * To force that a value is equal, see [EqualToValidable].
 */
class NotEqualToValidable(comparedValue: String, message: String? = null) : BaseValidable(
    validator = { value -> value !== comparedValue },
    errorFor = { value ->
        message ?: "$value should not be equal to $comparedValue."
    }
)
