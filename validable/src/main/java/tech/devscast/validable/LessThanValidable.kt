package tech.devscast.validable

/**
 * Validates that a value is less than another value.
 * To force that a value is less than or equal to another value, see [LessThanOrEqualValidable].
 * To force a value is greater than another value, see [GreaterThanValidable].
 */
class LessThanValidable(comparedValue: Int, message: String = "") : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() < comparedValue
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message.ifBlank { "$value should be less than to $comparedValue." }
    }
)
