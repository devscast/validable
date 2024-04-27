package tech.devscast.validable

/**
 * Validates that a value is numerically less than the specified value.
 *
 * @param comparedValue
 * The value to compare against.
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see LessThanOrEqualValidable
 * @see GreaterThanValidable
 */
class LessThanValidable(comparedValue: Int, message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() < comparedValue
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value should be less than to $comparedValue."
    }
)
