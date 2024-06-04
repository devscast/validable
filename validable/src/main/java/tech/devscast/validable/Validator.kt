package tech.devscast.validable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberValidator(
    vararg fields: BaseValidable,
) = remember {
    Validator(fields = fields)
}

class Validator(private vararg val fields: BaseValidable) {

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