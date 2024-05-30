Validates that a value is numerically less than the specified value.

```kotlin
val limit = 18

val numberTextField = LessThanValidable(
    limit,
    "The value must be < $limit"
)

```