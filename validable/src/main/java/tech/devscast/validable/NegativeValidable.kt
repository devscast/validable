package tech.devscast.validable

/**
 * Validates that a value is a negative number.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see NegativeOrZeroValidable
 */
class NegativeValidable(message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() < 0.0
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value should be a negative number."
    }
)
