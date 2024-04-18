package tech.devscast.validable

import java.net.MalformedURLException
import java.net.URL

/**
 * Validates that a value is a valid URL string.
 */
class UrlValidable(message: String = "") : BaseValidable(
    validator = { value ->
        try {
            URL(value)
            true
        } catch (e: MalformedURLException) {
            false
        }
    },
    errorFor = { _ -> message.ifBlank { "This value is not a valid URL." } }
)
