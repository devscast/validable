//[validable](../../../../index.md)/[tech.devscast.validable](../../index.md)/[CardScheme](../index.md)/[Companion](index.md)/[merge](merge.md)

# merge

[androidJvm]\
fun [merge](merge.md)(vararg schemes: [CardScheme](../index.md)): [CardScheme](../index.md)

Merges multiple card schemes into a single one.

This static method combines the regular expression patterns from all the provided `CardScheme` objects into a single list. This allows for validating cards against a combination of schemes.

#### Return

A new `CardScheme` object containing the combined patterns.

#### Parameters

androidJvm

| | |
|---|---|
| schemes | The `CardScheme` objects to be merged. |
