package tech.devscast.validable.delegates

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import tech.devscast.validable.EmailValidable
import kotlin.properties.ReadOnlyProperty

@Composable
fun emailValidable() : ReadOnlyProperty<Any?,EmailValidable> {
    val instance = remember {
        EmailValidable()
    }

    return ReadOnlyProperty { _, _ ->
        instance
    }
}