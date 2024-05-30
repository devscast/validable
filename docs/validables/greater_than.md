Validates that a value is numerically greater than the specified value.

```kotlin  
val comparedValue = 10

val numberField = GreaterThanValidable(
    comparedValue,
    "The value must be > $comparedValue"
)
```
