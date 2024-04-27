package tech.devscast.validable

/**
 * Validates that a given number is between some minimum and maximum.
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
