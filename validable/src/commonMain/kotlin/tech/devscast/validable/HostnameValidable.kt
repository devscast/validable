package tech.devscast.validable

import tech.devscast.validable.util.matches

private const val HOSTNAME_PATTERN =
    "^(?!-)(?!.*\\d+\\.\\d+\\.\\d+\\.\\d+)(?!.*\\.example\$)(?!.*\\.invalid\$)(?!.*\\.localhost\$)(?!.*\\.test\$)[A-Za-z0-9-]{1,63}(?<!-)(\\.[A-Za-z0-9-]{1,63})*\$"

/**
 * Validates that the given value is a valid host name
 *
 * The following top-level domains (TLD) are reserved according to RFC 2606
 * and that's why hostnames containing them are not considered valid: .example, .invalid, .localhost, and .test.
 *
 * @param message
 * (Optional) Custom error message for validation failure.
 *
 * @see [IpValidable]
 */
class HostnameValidable(message: String? = null) : BaseValidable(
    validator = { value -> matches(HOSTNAME_PATTERN, value) },
    errorFor = { value -> message ?: "$value is not a valid hostname" }
)
