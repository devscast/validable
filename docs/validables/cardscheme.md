Validates that a card number belongs to a specified scheme.

```kotlin  
val cardField = remember { 
    CardSchemeValidable(
        CardScheme.MasterCard,
        "Only MasterCard is supported"
    ) 
}

val multipleCardField = remember {
    CardSchemeValidable(
        CardScheme.merge(CardScheme.MasterCard, CardScheme.Visa),
        "Invalid Card"
    )
}

```