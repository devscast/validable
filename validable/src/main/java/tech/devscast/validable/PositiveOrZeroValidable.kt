package tech.devscast.validable

/**
 * Validates that a value is a positive number or equal to zero.
 * If you don't want to allow zero as value, use [PositiveValidable] instead.
 */
class PositiveOrZeroValidable(message: String = "") : BaseValidable(
    validator = { value ->
        try {
            value.toFloat() >= 0.0
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { text ->
        message.ifBlank { "$text should be a positive number or zero." }
    }
)
