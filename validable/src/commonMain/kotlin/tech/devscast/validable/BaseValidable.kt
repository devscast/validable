package tech.devscast.validable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Base class for implementing custom validations on string values.
 *
 * This class provides core functionalities for validation, including storing the value,
 * checking validity based on a provided [validator] function, and retrieving error messages.
 * Subclasses can inherit from this class and override the [validator] and [errorFor] lambdas
 * to implement specific validation rules and error messages for their needs.
 *
 */
open class BaseValidable(
    private val validator: (String) -> Boolean = { true },
    private val errorFor: (String) -> String = { "" }
) {

    /** Value to be used by the text field */
    //(must be state to trigger recomposition)
    var value: String by mutableStateOf("")

    /** The error message if any */
    val errorMessage: String?
        get() = getError()

    /**
     * Flag to control displaying validation errors.
     *
     * determines whether validation error messages are shown.
     * By default, it's set to false, be cause we can't show the errors when the form is not submitted yet.
     *
     * Uses [enableShowErrors] to enable error display.
     */
    private var displayErrors: Boolean by mutableStateOf(false)

    /**
     * calls the `validator` lambda with the current `value` to check validity.
     */
    val isValid: Boolean
        get() = validator(value)

    /**
     * Enables displaying validation errors.
     * Called when the form is submitted
     */
    fun enableShowErrors() {
        displayErrors = true
    }


    /**
     * Checks if there's a validation error and errors are enabled for display.
     */
    fun hasError() = !isValid && displayErrors

    /** Retrieves error message passed through [errorFor] */
    private fun getError(): String? {
        return if (hasError()) {
            errorFor(value)
        } else {
            null
        }
    }
}
