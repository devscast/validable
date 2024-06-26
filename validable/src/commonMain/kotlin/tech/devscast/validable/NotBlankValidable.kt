package tech.devscast.validable

/**
 *  Validates that the value is not blank - neither empty string nor whitespace are valid
 */
class NotBlankValidable(message: String? = null) : BaseValidable(
    validator = { value -> value.isNotBlank() },
    errorFor = { _ ->
        message ?: "This field cannot be blank"
    }
)
