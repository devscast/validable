package tech.devscast.validable

/**
 * Validates that a value is greater than another value
 * To force that a value is greater than or equal to another value, see [GreaterThanOrEqualValidable].
 * To force a value is less than another value, see [LessThanValidable].
 */
class GreaterThanValidable(comparedValue: Int, message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() > comparedValue
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value should be equal to $comparedValue."
    }
)
