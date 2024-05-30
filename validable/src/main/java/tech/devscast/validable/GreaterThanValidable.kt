package tech.devscast.validable

/**
 * Validates that a value is numerically greater than the specified value.
 *
 * @param comparedValue
 *  The value to compare against.
 * @param message
 *  (Optional) Custom error message for validation failure.
 *
 * @see GreaterThanOrEqualValidable
 * @see LessThanValidable
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
