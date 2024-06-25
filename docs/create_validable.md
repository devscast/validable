# Create a validable

You can create a validable with a custom validation logic.

All you need to do is to extend the `BaseValidable` class, which takes two functions as parameters:

- `validator`: This function checks if the value meets a specified condition and returns a boolean.
- `errorFor`: Is called when the value does not meet the condition and returns a string as the error message.

Let's see an example of a custom validable that checks if an input contains the word "devscast"

```kotlin
class DevscastValidable : BaseValidable(
    validator = { value ->
        value.contains("devscast", ignoreCase = true)
    },
    errorFor = { value ->
        "$value does not contain the word 'devscast'."
    }
)
```