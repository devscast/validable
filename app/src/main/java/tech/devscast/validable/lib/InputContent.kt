package tech.devscast.validable.lib

class InputContent(val defaultValue: String = "") {
    var value = defaultValue

    private var canBeNull : Boolean = true
    private var isEmail : Boolean = true
    private var isNumber : Boolean = true

    private var isSubmitted : Boolean = false

    var isValid = true

    val errors = arrayListOf<String>()

    fun submit(next: (text: String) -> Unit) {
        isSubmitted = true

        if (!this.canBeNull && value.isBlank()) {
            this.errors.add("Ne peut etre vide")
            next("Ne peut etre vide")
        } else {
            next(value)
        }
    }

    fun isNotEmpty() {
        this.canBeNull = false
    }

    fun isNumber() {
        this.isNumber = true
    }

    fun withNewValue(newValue: String): InputContent {
        return InputContent(newValue)
    }

    fun withError(error: String): Boolean {
        return InputContent().errors.add(error)
    }
}