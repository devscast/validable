package tech.devscast.validable

/**
 * Validates that a value is equal to the specified value,
 *
 *  @param comparedValue
 *  The value to compare against.
 *  @param message
 *  (Optional) Custom error message for validation failure.
 *
 *  @see [NotEqualToValidable].
 */
class EqualToValidable(comparedValue: String, message: String? = null) : BaseValidable(
    validator = { value -> value === comparedValue },
    errorFor = { value ->
        message ?: "$value should be equal to $comparedValue."
    }
)
