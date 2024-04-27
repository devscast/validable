package tech.devscast.validable

/**
 * Validates that a value is a positive number.
 * Zero is neither positive nor negative,
 * so you must use [PositiveOrZeroValidable] if you want to allow zero as value.
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
