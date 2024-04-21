package tech.devscast.validable

/**
 * Validates that a value is a negative number.
 * Zero is neither positive nor negative,
 * so you must use [NegativeOrZeroValidable] if you want to allow zero as value.
 */
class NegativeValidable(message: String = "") : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() < 0.0
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message.ifBlank { "$value should be a negative number." }
    }
)
