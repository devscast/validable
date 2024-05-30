Validates that a value is numerically less than or equal to the specified value.

```kotlin
val max = 9

val numberTextField = LessThanOrEqualValidable(
    max,
    "The value must be <= $max"
)
```