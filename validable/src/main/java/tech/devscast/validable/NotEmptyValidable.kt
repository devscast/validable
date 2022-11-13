package tech.devscast.validable

class NotEmptyValidable : BaseValidable(validator = ::isFieldValid, errorFor = ::fieldValidationError)

private fun isFieldValid(text: String): Boolean {
    return text.isNotBlank()
}

private fun fieldValidationError(text: String): String {
    return "This field is required"
}
