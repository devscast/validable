package tech.devscast.validable.lib

import kotlin.reflect.KProperty

class validable(rules: Form.() -> Unit) {

    private val from = Form()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Form {
        return this.from
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.from.value = value
    }
}