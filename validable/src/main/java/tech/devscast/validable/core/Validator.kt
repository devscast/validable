package tech.devscast.validable.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import tech.devscast.validable.BaseValidable

@Composable
fun rememberValidator(
    vararg fields: BaseValidable,
) = remember {
    Validator(fields = fields)
}

class Validator(private vararg val fields: BaseValidable) {

    val isValid: Boolean
        @Composable
        get() {
            val isValidValue by produceState(initialValue = false, fields.map { it.isValid }) {
                this.value = fields.none { it.isValid.not() }
            }
            return isValidValue
        }
    fun validate(action: () -> Unit) {
        val isThereAnyError = fields.map {
            it.enableShowErrors()
            it.hasError()
        }.contains(true)

        if (isThereAnyError.not()) {
            action()
        }
    }
}