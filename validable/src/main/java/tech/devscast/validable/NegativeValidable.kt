package tech.devscast.validable

class NegativeValidable : BaseValidable(validator = ::isNegativeValue, errorFor = ::negativeValidationError)

private fun isNegativeValue(value: String): Boolean {
    return try {
        value.toFloat() < 0.0
    } catch (e: Exception) {
        false
    }
}

private fun negativeValidationError(text: String): String {
    return text.ifBlank { "This value should be negative." }
}
