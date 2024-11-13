package tech.devscast.validable.util

internal expect fun matches(pattern: String, input: String): Boolean
internal expect fun matches(patterns: List<String>, input: String) : Boolean