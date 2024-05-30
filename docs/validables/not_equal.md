Validates that a value is not equal to the specified value

```kotlin
val notAcceptedNumber = 7

val numberTextField = NotEqualToValidable(
    notAcceptedNumber,
    "The value must be different from $notAcceptedNumber"
)
```