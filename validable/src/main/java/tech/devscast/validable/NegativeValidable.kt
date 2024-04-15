package tech.devscast.validable

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
