package tech.devscast.validable.lib

import androidx.compose.runtime.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@Composable
fun validable(initialValue: String,rules: InputContent.() -> Unit) : ReadWriteProperty<Any?, InputContent> {

    var inputContent by remember { mutableStateOf(InputContent(initialValue)) }
    rules(inputContent)

    return object : ReadWriteProperty<Any?,InputContent> {
        /**
         * Returns the value of the property for the given object.
         * @param thisRef the object for which the value is requested.
         * @param property the metadata for the property.
         * @return the property value.
         */
        override fun getValue(thisRef: Any?, property: KProperty<*>): InputContent {
           return inputContent
        }

        /**
         * Sets the value of the property for the given object.
         * @param thisRef the object for which the value is requested.
         * @param property the metadata for the property.
         * @param value the value to set.
         */
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: InputContent) {
            inputContent = value
        }

    }

    
}