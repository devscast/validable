package tech.devscast.validable

import java.util.regex.Pattern

private const val IP_V4_PATTERN = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\$"

/**
 * Validates that a value is a valid IP address
 * TODO: add support for IP v6
 */
class IpValidable(message: String? = null) : BaseValidable(
    validator = { value -> Pattern.matches(IP_V4_PATTERN, value) },
    errorFor = { value -> message ?: "$value is not a valid IP address." }
)
