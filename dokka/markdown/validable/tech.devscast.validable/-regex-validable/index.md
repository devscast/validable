//[validable](../../../index.md)/[tech.devscast.validable](../index.md)/[RegexValidable](index.md)

# RegexValidable

class [RegexValidable](index.md)(pattern: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [BaseValidable](../-base-validable/index.md)

Validates that a value matches a regular expression.

#### Parameters

androidJvm

| | |
|---|---|
| pattern | The regular expression pattern to match against. |
| message | (Optional) Custom error message for validation failure. |

## Constructors

| | |
|---|---|
| [RegexValidable](-regex-validable.md) | [androidJvm]<br>constructor(pattern: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [errorMessage](../-base-validable/error-message.md) | [androidJvm]<br>val [errorMessage](../-base-validable/error-message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The error message if any |
| [isValid](../-base-validable/is-valid.md) | [androidJvm]<br>val [isValid](../-base-validable/is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>calls the `validator` lambda with the current `value` to check validity. |
| [value](../-base-validable/value.md) | [androidJvm]<br>var [value](../-base-validable/value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value to be used by the text field |

## Functions

| Name | Summary |
|---|---|
| [enableShowErrors](../-base-validable/enable-show-errors.md) | [androidJvm]<br>fun [enableShowErrors](../-base-validable/enable-show-errors.md)()<br>Enables displaying validation errors. Called when the form is submitted |
| [hasError](../-base-validable/has-error.md) | [androidJvm]<br>fun [hasError](../-base-validable/has-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if there's a validation error and errors are enabled for display. |
