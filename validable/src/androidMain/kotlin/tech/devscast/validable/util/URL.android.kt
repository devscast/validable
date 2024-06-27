package tech.devscast.validable.util

import java.net.MalformedURLException
import java.net.URL

internal actual fun validateUrl(url: String): Boolean {
    return try {
        URL(url)
        true
    } catch (e: MalformedURLException) {
        false
    }
}