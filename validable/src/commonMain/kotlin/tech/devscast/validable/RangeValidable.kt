package tech.devscast.validable

/**
 * Validates that a given number is between some minimum and maximum.
 *
 * @param minValue
 * The minimum allowed value.
 * @param maxValue
 * The maximum allowed value.
 * @param message
 * (Optional) Custom error message for validation failure.
 */
class RangeValidable(minValue: Int, maxValue: Int, message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            (minValue..maxValue).contains(value.toInt())
        } catch (e: Exception) {
            false
        }
    },
    errorFor = { value ->
        message ?: "$value value should be between $minValue and $maxValue."
    }
)
