package tech.devscast.validable

/**
 * Validates that a value is less than or equal to another value.
 * To force that a value is less than another value, see [LessThanValidable].
 */
class LessThanOrEqualValidable(comparedValue: Int, message: String = ""): BaseValidable(
    validator = { value ->
        try {
            value.toInt() <= comparedValue
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message.ifBlank { "$value should be less than or equal to $comparedValue." }
    }
)
