//[validable](../../../index.md)/[tech.devscast.validable](../index.md)/[GreaterThanOrEqualValidable](index.md)

# GreaterThanOrEqualValidable

class [GreaterThanOrEqualValidable](index.md)(comparedValue: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) : [BaseValidable](../-base-validable/index.md)

Validates that a value is numerically greater than or equal to the specified value.

#### Parameters

androidJvm

| | |
|---|---|
| comparedValue | The value to compare against. |
| message | (Optional) Custom error message for validation failure. |

#### See also

| |
|---|
| [GreaterThanValidable](../-greater-than-validable/index.md) |

## Constructors

| | |
|---|---|
| [GreaterThanOrEqualValidable](-greater-than-or-equal-validable.md) | [androidJvm]<br>constructor(comparedValue: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

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
