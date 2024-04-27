package tech.devscast.validable

/**
 * Validates that a value is equal to another value,
 * To force that a value is not equal, see [NotEqualToValidable].
 */
class EqualToValidable(comparedValue: String, message: String? = null) : BaseValidable(
    validator = { value -> value === comparedValue },
    errorFor = { value ->
        message ?: "$value should be equal to $comparedValue."
    }
)
