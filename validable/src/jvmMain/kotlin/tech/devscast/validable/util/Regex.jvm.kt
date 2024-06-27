package tech.devscast.validable.util

import java.util.regex.Pattern

internal actual fun matches(pattern: String, input: String): Boolean {
    return Pattern.matches(pattern, input)
}

internal actual fun matches(
    patterns: List<String>,
    input: String
): Boolean {
    val compiledPatterns = patterns.map { Pattern.compile(it) }
    return compiledPatterns.any { pattern -> pattern.matcher(input).matches() }
}