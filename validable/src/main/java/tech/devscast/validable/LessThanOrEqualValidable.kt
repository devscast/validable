package tech.devscast.validable

/**
 * Validates that a value is numerically less than or equal to the specified value.
 *
 * @param comparedValue
 *  The value to compare against.
 * @param message
 *  (Optional) Custom error message for validation failure.
 *
 *  @see LessThanValidable
 */

class LessThanOrEqualValidable(comparedValue: Int, message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toInt() <= comparedValue
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value should be less than or equal to $comparedValue."
    }
)
