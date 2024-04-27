package tech.devscast.validable

import java.net.MalformedURLException
import java.net.URL

/**
 * Validates that a value is a valid URL string.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see HostnameValidable
 */
class UrlValidable(message: String? = null) : BaseValidable(
    validator = { value ->
        try {
            URL(value)
            true
        } catch (e: MalformedURLException) {
            false
        }
    },
    errorFor = { _ -> message ?: "This value is not a valid URL." }
)
