Validates that a value is numerically greater than or equal to the specified value.

```kotlin  
val minAge = 18

val ageTextField = GreaterThanOrEqualValidable(
    minAge,
    "The minimum allowed age is $minAge"
)
```