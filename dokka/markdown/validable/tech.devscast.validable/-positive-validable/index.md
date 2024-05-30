//[validable](../../../index.md)/[tech.devscast.validable](../index.md)/[PositiveValidable](index.md)

# PositiveValidable

class [PositiveValidable](index.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [BaseValidable](../-base-validable/index.md)

Validates that a value is a positive number.

#### Parameters

androidJvm

| | |
|---|---|
| message | (Optional) Custom error message for validation failure. |

#### See also

| |
|---|
| [PositiveOrZeroValidable](../-positive-or-zero-validable/index.md) |

## Constructors

| | |
|---|---|
| [PositiveValidable](-positive-validable.md) | [androidJvm]<br>constructor(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

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
