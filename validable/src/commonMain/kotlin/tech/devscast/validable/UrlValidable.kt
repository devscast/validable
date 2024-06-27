package tech.devscast.validable

import tech.devscast.validable.util.ExperimentalValidableApi
import tech.devscast.validable.util.validateUrl

/**
 * Validates that a value is a valid URL string.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see HostnameValidable
 */
@ExperimentalValidableApi
class UrlValidable(message: String? = null) : BaseValidable(
    validator = { value -> validateUrl(value) },
    errorFor = { _ -> message ?: "This value is not a valid URL." }
)
