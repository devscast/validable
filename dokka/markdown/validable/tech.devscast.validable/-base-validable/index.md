//[validable](../../../index.md)/[tech.devscast.validable](../index.md)/[BaseValidable](index.md)

# BaseValidable

open class [BaseValidable](index.md)(validator: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { true }, errorFor: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { &quot;&quot; })

Base class for implementing custom validations on string values.

This class provides core functionalities for validation, including storing the value, checking validity based on a provided validator function, and retrieving error messages. Subclasses can inherit from this class and override the validator and errorFor lambdas to implement specific validation rules and error messages for their needs.

#### Inheritors

| |
|---|
| [CardSchemeValidable](../-card-scheme-validable/index.md) |
| [EmailValidable](../-email-validable/index.md) |
| [EqualToValidable](../-equal-to-validable/index.md) |
| [GreaterThanOrEqualValidable](../-greater-than-or-equal-validable/index.md) |
| [GreaterThanValidable](../-greater-than-validable/index.md) |
| [HostnameValidable](../-hostname-validable/index.md) |
| [IpValidable](../-ip-validable/index.md) |
| [LessThanOrEqualValidable](../-less-than-or-equal-validable/index.md) |
| [LessThanValidable](../-less-than-validable/index.md) |
| [NegativeOrZeroValidable](../-negative-or-zero-validable/index.md) |
| [NegativeValidable](../-negative-validable/index.md) |
| [NotEmptyValidable](../-not-empty-validable/index.md) |
| [NotEqualToValidable](../-not-equal-to-validable/index.md) |
| [PositiveOrZeroValidable](../-positive-or-zero-validable/index.md) |
| [PositiveValidable](../-positive-validable/index.md) |
| [RangeValidable](../-range-validable/index.md) |
| [RegexValidable](../-regex-validable/index.md) |
| [UrlValidable](../-url-validable/index.md) |

## Constructors

| | |
|---|---|
| [BaseValidable](-base-validable.md) | [androidJvm]<br>constructor(validator: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { true }, errorFor: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { &quot;&quot; }) |

## Properties

| Name | Summary |
|---|---|
| [errorMessage](error-message.md) | [androidJvm]<br>val [errorMessage](error-message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>The error message if any |
| [isValid](is-valid.md) | [androidJvm]<br>val [isValid](is-valid.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>calls the `validator` lambda with the current `value` to check validity. |
| [value](value.md) | [androidJvm]<br>var [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Value to be used by the text field |

## Functions

| Name | Summary |
|---|---|
| [enableShowErrors](enable-show-errors.md) | [androidJvm]<br>fun [enableShowErrors](enable-show-errors.md)()<br>Enables displaying validation errors. Called when the form is submitted |
| [hasError](has-error.md) | [androidJvm]<br>fun [hasError](has-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if there's a validation error and errors are enabled for display. |
