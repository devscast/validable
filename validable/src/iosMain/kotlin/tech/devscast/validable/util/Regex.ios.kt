package tech.devscast.validable.util

internal actual fun matches(pattern: String, input: String): Boolean {
    return Regex(pattern).matches(input)
}

internal actual fun matches(
    patterns: List<String>,
    input: String
): Boolean {
    for (pattern in patterns) {
        if (Regex(pattern).matches(input)) {
            return true
        }
    }
    return false
}