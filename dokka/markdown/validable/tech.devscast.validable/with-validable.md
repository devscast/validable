//[validable](../../index.md)/[tech.devscast.validable](index.md)/[withValidable](with-validable.md)

# withValidable

[androidJvm]\
fun [withValidable](with-validable.md)(vararg fields: [BaseValidable](-base-validable/index.md), next: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Executes a given block of code only if all provided validables are valid.

#### Parameters

androidJvm

| | |
|---|---|
| fields | A variable number validables objects to validate. |
| next | the block of code to execute if all validations pass. |
