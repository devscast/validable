package tech.devscast.validable

/**
 * Validates that a value is a negative number or equal to zero.
 * If you don't want to allow zero as value, use [NegativeValidable] instead.
 */
class NegativeOrZeroValidable(message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() <= 0.0
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value should be a negative number or zero."
    }
)
