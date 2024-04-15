package tech.devscast.validable

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
