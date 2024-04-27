package tech.devscast.validable

/**
 * Executes a given block of code only if all provided validables are valid.
 *
 * @param fields
 * A variable number validables objects to validate.
 * @param next
 * the block of code to execute if all validations pass.
 */
fun withValidable(vararg fields: BaseValidable, next: () -> Unit) {
    val errors: List<Boolean> = fields.map {
        it.enableShowErrors()
        it.hasError()
    }

    if (!errors.contains(true)) {
        next()
    }
}
