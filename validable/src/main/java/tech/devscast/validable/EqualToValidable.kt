package tech.devscast.validable

/**
 * Validates that a value is equal to another value,
 * To force that a value is not equal, see [NotEqualToValidable].
 */
class EqualToValidable(comparedValue: String, message: String = "") : BaseValidable(
    validator = { value -> value === comparedValue },
    errorFor = { value ->
        message.ifBlank { "$value should be equal to $comparedValue." }
    }
)
