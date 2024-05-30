Validates that a value is equal to the specified value

```kotlin  

val comparedValue = "Hello World"

val textField = EqualToValidable(
    comparedValue,
    "The value does not match $comparedValue"
)
```