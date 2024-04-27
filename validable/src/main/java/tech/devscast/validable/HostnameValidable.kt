package tech.devscast.validable

import java.util.regex.Pattern

private const val HOSTNAME_PATTERN =
    "^(?!-)(?!.*\\d+\\.\\d+\\.\\d+\\.\\d+)(?!.*\\.example\$)(?!.*\\.invalid\$)(?!.*\\.localhost\$)(?!.*\\.test\$)[A-Za-z0-9-]{1,63}(?<!-)(\\.[A-Za-z0-9-]{1,63})*\$"

/**
 * Validates that the given value is a valid host name
 * To forces that value is an IP address see [IpValidable]
 *
 * The following top-level domains (TLD) are reserved according to RFC 2606
 * and that's why hostnames containing them are not considered valid: .example, .invalid, .localhost, and .test.
 */
class HostnameValidable(message: String? = null) : BaseValidable(
    validator = { value -> Pattern.matches(HOSTNAME_PATTERN, value) },
    errorFor = { value -> message ?: "$value is not a valid hostname" }
)
