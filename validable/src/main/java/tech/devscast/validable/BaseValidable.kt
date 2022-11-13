package tech.devscast.validable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class BaseValidable(
    private val validator: (String) -> Boolean = { true },
    private val errorFor: (String) -> String = { "" }
) {

    var value: String by mutableStateOf("")
    val errorMessage: String?
        get() = getError()

    private var displayErrors: Boolean by mutableStateOf(false)

    val isValid: Boolean
        get() = validator(value)

    fun enableShowErrors() {
        displayErrors = true
    }

    fun hasError() = !isValid && displayErrors

    private fun getError(): String? {
        return if (hasError()) {
            errorFor(value)
        } else {
            null
        }
    }
}
