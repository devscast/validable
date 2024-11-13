package tech.devscast.validable.util


internal actual fun validateUrl(url: String): Boolean {
    val regexPattern =
        "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)"
    return matches(regexPattern, url)
}