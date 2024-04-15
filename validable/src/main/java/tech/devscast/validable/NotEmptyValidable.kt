package tech.devscast.validable

class NotEmptyValidable(message: String = "") : BaseValidable(
    validator = { value -> value.isNotBlank() },
    errorFor = { _ ->
        message.ifBlank { "This field is required" }
    }
)
