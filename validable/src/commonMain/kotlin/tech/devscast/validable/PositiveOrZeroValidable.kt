package tech.devscast.validable

/**
 * Validates that a value is a positive number or equal to zero.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see PositiveValidable
 */
class PositiveOrZeroValidable(message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() >= 0.0
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { text ->
        message ?: "$text should be a positive number or zero."
    }
)
