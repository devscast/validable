Validates that a value matches a regular expression.

```kotlin
val pattern = "^[0-9]+$"

val textField = RegexValidable(pattern,"This value is not valid.")
```