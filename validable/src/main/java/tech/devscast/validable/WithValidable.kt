package tech.devscast.validable

fun withValidable(vararg fields: BaseValidable, next: () -> Unit) {
    val errors: List<Boolean> = fields.map {
        it.enableShowErrors()
        it.hasError()
    }

    if (!errors.contains(true)) {
        next()
    }
}
