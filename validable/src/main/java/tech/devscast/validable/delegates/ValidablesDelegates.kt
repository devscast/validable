package tech.devscast.validable.delegates

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import tech.devscast.validable.EmailValidable
import tech.devscast.validable.NotEmptyValidable
import kotlin.properties.ReadOnlyProperty

@Deprecated("Use remember { NotEmptyValidable() } instead")
@Composable
fun validableNotEmpty(): ReadOnlyProperty<Any?, NotEmptyValidable> {
    val instance = remember {
        NotEmptyValidable()
    }

    return ReadOnlyProperty { _, _ ->
        instance
    }
}

@Deprecated("Use remember { EmailValidable() } instead")
@Composable
fun validableEmail(): ReadOnlyProperty<Any?, EmailValidable> {
    val instance = remember {
        EmailValidable()
    }

    return ReadOnlyProperty { _, _ ->
        instance
    }
}
