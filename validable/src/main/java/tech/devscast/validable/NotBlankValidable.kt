package tech.devscast.validable

/**
 *  Validates that the value is not blank - empty string or whitespace are not valid
 */
class NotBlankValidable(message: String? = null) : BaseValidable(
    validator = { value -> value.isNotBlank() },
    errorFor = { _ ->
        message ?: "This field cannot be blank"
    }
)
