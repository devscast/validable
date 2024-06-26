package tech.devscast.validable

/**
 * Validates that a value is a positive number.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see PositiveOrZeroValidable
 */
class PositiveValidable(message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() > 0.0
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value should be a positive number."
    }
)
