Validates that a card number belongs to a specified scheme.

```kotlin  

// Validate if a text is a MasterCard number
val cardField = CardSchemeValidable(
        CardScheme.MasterCard,
        "Only MasterCard is supported"
)

// Supporting multiple cardScheme
val multipleCardField = CardSchemeValidable(
        CardScheme.MasterCard,CardScheme.Visa,
        "Only MasterCard and Visa are supported"
)

// Merging multiple CardSchemes into one
val mixedCardScheme = CardScheme.merge(CardScheme.MasterCard, CardScheme.Visa)

val multipleCardField = CardSchemeValidable(
    mixedCardScheme,
    "Only MasterCard and Visa are supported"
)
```