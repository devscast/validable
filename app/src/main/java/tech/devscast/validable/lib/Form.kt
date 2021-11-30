package tech.devscast.validable.lib

class Form {

    var value = ""

    private var canBeNull : Boolean = true
    private var isEmail : Boolean = true
    private var isNumber : Boolean = true

    private val isSubmitted : Boolean = false

    var isValid = true

    val errors = arrayListOf<String>()

    fun submit(next: (text: String) -> Unit) {
        isValid = this.checkIfValid()
        if (isValid) {
            next(this.value)
        }
    }

    fun isNotEmpty() {
        this.canBeNull = true
    }

    fun isNumber() {
        this.isNumber = true
    }

    private fun checkIfValid() : Boolean {
        return if (!isSubmitted) {
            errors.isNotEmpty()
        } else {
            false
        }
    }


}