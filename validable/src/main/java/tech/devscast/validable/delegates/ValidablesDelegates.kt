package tech.devscast.validable.delegates

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import tech.devscast.validable.EmailValidable
import tech.devscast.validable.NotEmptyValidable
import kotlin.properties.ReadOnlyProperty

@Composable
fun validableNotEmpty(): ReadOnlyProperty<Any?, NotEmptyValidable> {
    val instance = remember {
        NotEmptyValidable()
    }

    return ReadOnlyProperty { _, _ ->
        instance
    }
}

@Composable
fun validableEmail(): ReadOnlyProperty<Any?, EmailValidable> {
    val instance = remember {
        EmailValidable()
    }

    return ReadOnlyProperty { _, _ ->
        instance
    }
}
