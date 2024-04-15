package tech.devscast.validable

/**
 * Validates that a value is greater than or equal to another value.
 * To force that a value is greater than another value, see [GreaterThanValidable].
 */
class GreaterThanOrEqualValidable(comparedValue: Int, message: String = "") : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() >= comparedValue
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message.ifBlank { "$value should be greater than or equal to $comparedValue." }
    }
)
